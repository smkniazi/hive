/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.llap.io.metadata;

import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.hive.ql.io.orc.encoded.OrcBatchKey;
import org.apache.orc.OrcProto;
import org.apache.orc.OrcProto.RowIndexEntry;
import org.apache.orc.StripeInformation;
import org.apache.orc.impl.OrcIndex;

public class OrcStripeMetadata implements ConsumerStripeMetadata {
  private final OrcBatchKey stripeKey;
  private final List<OrcProto.ColumnEncoding> encodings;
  private final List<OrcProto.Stream> streams;
  private final String writerTimezone;
  private final long rowCount;
  private OrcIndex rowIndex;

  public OrcStripeMetadata(OrcBatchKey stripeKey, OrcProto.StripeFooter footer,
      OrcIndex orcIndex, StripeInformation stripe) throws IOException {
    this.stripeKey = stripeKey;
    streams = footer.getStreamsList();
    encodings = footer.getColumnsList();
    writerTimezone = footer.getWriterTimezone();
    rowCount = stripe.getNumberOfRows();
<<<<<<< HEAD
    rowIndex = orcIndex;
=======
    rowIndex = mr.readRowIndex(stripe, schema, footer, true, includes, null,
        sargColumns, writerVersion, null, null);

    estimatedMemUsage = SIZE_ESTIMATOR.estimate(this, SIZE_ESTIMATORS);
    this.writerVersion = writerVersion;
  }

  private OrcStripeMetadata(Object id) {
    stripeKey = new OrcBatchKey(id, 0, 0);
    encodings = new ArrayList<>();
    streams = new ArrayList<>();
    writerTimezone = "";
    schema = TypeDescription.fromString("struct<x:int>");
    rowCount = estimatedMemUsage = 0;
  }

  @VisibleForTesting
  public static OrcStripeMetadata createDummy(Object id) {
    OrcStripeMetadata dummy = new OrcStripeMetadata(id);
    dummy.encodings.add(OrcProto.ColumnEncoding.getDefaultInstance());
    dummy.streams.add(OrcProto.Stream.getDefaultInstance());
    OrcProto.RowIndex ri = OrcProto.RowIndex.newBuilder().addEntry(
        OrcProto.RowIndexEntry.newBuilder().addPositions(1).setStatistics(
            OrcFileMetadata.createStatsDummy())).build();
    OrcProto.BloomFilterIndex bfi = OrcProto.BloomFilterIndex.newBuilder().addBloomFilter(
        OrcProto.BloomFilter.newBuilder().addBitset(0)).build();
    dummy.rowIndex = new OrcIndex(
        new OrcProto.RowIndex[] { ri },
        new OrcProto.Stream.Kind[] { OrcProto.Stream.Kind.BLOOM_FILTER_UTF8 },
        new OrcProto.BloomFilterIndex[] { bfi });
    return dummy;
  }

  public boolean hasAllIndexes(boolean[] includes) {
    for (int i = 0; i < includes.length; ++i) {
      if (includes[i] && rowIndex.getRowGroupIndex()[i] == null) return false;
    }
    return true;
  }

  public void loadMissingIndexes(DataReader mr, StripeInformation stripe, boolean[] includes,
      boolean[] sargColumns) throws IOException {
    // Do not lose the old indexes. Create a super set includes
    OrcProto.RowIndex[] existing = getRowIndexes();
    boolean superset[] = new boolean[Math.max(existing.length, includes.length)];
    for (int i = 0; i < includes.length; i++) {
      superset[i] = includes[i];
    }
    for (int i = 0; i < existing.length; i++) {
      superset[i] = superset[i] || (existing[i] != null);
    }
    // TODO: should we save footer to avoid a read here?
    rowIndex = mr.readRowIndex(stripe, schema, null, true, superset,
        rowIndex.getRowGroupIndex(),
        sargColumns, writerVersion, rowIndex.getBloomFilterKinds(),
        rowIndex.getBloomFilterIndex());
    // TODO: theoretically, we should re-estimate memory usage here and update memory manager
>>>>>>> 7916965eaa... Revert "Revert "HIVE-16744 : LLAP index update may be broken after ORC switch (Sergey Shelukhin, reviewed by Prasanth Jayachandran)""
  }

  public int getStripeIx() {
    return stripeKey.stripeIx;
  }

  public OrcProto.RowIndex[] getRowIndexes() {
    return rowIndex.getRowGroupIndex();
  }

  public OrcProto.Stream.Kind[] getBloomFilterKinds() {
    return rowIndex.getBloomFilterKinds();
  }

  public OrcProto.BloomFilterIndex[] getBloomFilterIndexes() {
    return rowIndex.getBloomFilterIndex();
  }

  public List<OrcProto.ColumnEncoding> getEncodings() {
    return encodings;
  }

  public List<OrcProto.Stream> getStreams() {
    return streams;
  }

  public String getWriterTimezone() {
    return writerTimezone;
  }

  public OrcBatchKey getKey() {
    return stripeKey;
  }

  public long getRowCount() {
    return rowCount;
  }

  @VisibleForTesting
  public void resetRowIndex() {
    rowIndex = null;
  }

  @Override
  public RowIndexEntry getRowIndexEntry(int colIx, int rgIx) {
    return rowIndex.getRowGroupIndex()[colIx].getEntry(rgIx);
  }

  @Override
  public boolean supportsRowIndexes() {
    return true;
  }

  public OrcIndex getIndex() {
    return rowIndex;
  }

  @Override
  public String toString() {
    return "OrcStripeMetadata [stripeKey=" + stripeKey + ", rowCount="
        + rowCount + ", writerTimezone=" + writerTimezone + ", encodings="
        + encodings + ", streams=" + streams + ", rowIndex=" + rowIndex + "]";
  }
}
