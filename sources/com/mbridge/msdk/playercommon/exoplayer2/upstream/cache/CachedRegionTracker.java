package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.util.Log;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/* loaded from: classes5.dex */
public final class CachedRegionTracker implements Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    private static final String TAG = "CachedRegionTracker";
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final TreeSet<Region> regions = new TreeSet<>();
    private final Region lookupRegion = new Region(0, 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Region implements Comparable<Region> {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long j11, long j12) {
            this.startOffset = j11;
            this.endOffset = j12;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Region region) {
            long j11 = this.startOffset;
            long j12 = region.startOffset;
            if (j11 < j12) {
                return -1;
            }
            return j11 == j12 ? 0 : 1;
        }
    }

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        this.cache = cache;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex;
        synchronized (this) {
            try {
                Iterator<CacheSpan> descendingIterator = cache.addListener(str, this).descendingIterator();
                while (descendingIterator.hasNext()) {
                    mergeSpan(descendingIterator.next());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        long j11 = cacheSpan.position;
        Region region = new Region(j11, cacheSpan.length + j11);
        Region floor = this.regions.floor(region);
        Region ceiling = this.regions.ceiling(region);
        boolean regionsConnect = regionsConnect(floor, region);
        if (regionsConnect(region, ceiling)) {
            if (regionsConnect) {
                floor.endOffset = ceiling.endOffset;
                floor.endOffsetIndex = ceiling.endOffsetIndex;
            } else {
                region.endOffset = ceiling.endOffset;
                region.endOffsetIndex = ceiling.endOffsetIndex;
                this.regions.add(region);
            }
            this.regions.remove(ceiling);
            return;
        }
        if (!regionsConnect) {
            int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region.endOffsetIndex = binarySearch;
            this.regions.add(region);
            return;
        }
        floor.endOffset = region.endOffset;
        int i11 = floor.endOffsetIndex;
        while (true) {
            ChunkIndex chunkIndex = this.chunkIndex;
            if (i11 >= chunkIndex.length - 1) {
                break;
            }
            int i12 = i11 + 1;
            if (chunkIndex.offsets[i12] > floor.endOffset) {
                break;
            } else {
                i11 = i12;
            }
        }
        floor.endOffsetIndex = i11;
    }

    private boolean regionsConnect(Region region, Region region2) {
        return (region == null || region2 == null || region.endOffset != region2.startOffset) ? false : true;
    }

    public synchronized int getRegionEndTimeMs(long j11) {
        int i11;
        Region region = this.lookupRegion;
        region.startOffset = j11;
        Region floor = this.regions.floor(region);
        if (floor != null) {
            long j12 = floor.endOffset;
            if (j11 <= j12 && (i11 = floor.endOffsetIndex) != -1) {
                ChunkIndex chunkIndex = this.chunkIndex;
                if (i11 == chunkIndex.length - 1) {
                    if (j12 == chunkIndex.offsets[i11] + chunkIndex.sizes[i11]) {
                        return -2;
                    }
                }
                return (int) ((chunkIndex.timesUs[i11] + ((chunkIndex.durationsUs[i11] * (j12 - chunkIndex.offsets[i11])) / chunkIndex.sizes[i11])) / 1000);
            }
        }
        return -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        mergeSpan(cacheSpan);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        long j11 = cacheSpan.position;
        Region region = new Region(j11, cacheSpan.length + j11);
        Region floor = this.regions.floor(region);
        if (floor == null) {
            Log.e(TAG, "Removed a span we were not aware of");
            return;
        }
        this.regions.remove(floor);
        long j12 = floor.startOffset;
        long j13 = region.startOffset;
        if (j12 < j13) {
            Region region2 = new Region(j12, j13);
            int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region2.endOffset);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region2.endOffsetIndex = binarySearch;
            this.regions.add(region2);
        }
        long j14 = floor.endOffset;
        long j15 = region.endOffset;
        if (j14 > j15) {
            Region region3 = new Region(j15 + 1, j14);
            region3.endOffsetIndex = floor.endOffsetIndex;
            this.regions.add(region3);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void release() {
        this.cache.removeListener(this.cacheKey, this);
    }
}
