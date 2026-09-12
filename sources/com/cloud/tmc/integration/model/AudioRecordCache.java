package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.audio.recording.RecorderClient;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\u0002\u0010\rJ%\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J%\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J%\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J%\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J%\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J%\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003Jí\u0001\u0010\u001b\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u00062$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u00062$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u00062$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/cloud/tmc/integration/model/AudioRecordCache;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "recorderClientCache", "Ljava/util/HashMap;", "", "Lcom/cloud/tmc/integration/audio/recording/RecorderClient;", "Lkotlin/collections/HashMap;", "onStarts", "Lcom/cloud/tmc/kernel/bridge/extension/BridgeCallback;", "onStops", "onPauses", "onResumes", "onErrors", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getOnErrors", "()Ljava/util/HashMap;", "getOnPauses", "getOnResumes", "getOnStarts", "getOnStops", "getRecorderClientCache", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final /* data */ class AudioRecordCache extends BaseBean {
    private final HashMap<String, BridgeCallback> onErrors;
    private final HashMap<String, BridgeCallback> onPauses;
    private final HashMap<String, BridgeCallback> onResumes;
    private final HashMap<String, BridgeCallback> onStarts;
    private final HashMap<String, BridgeCallback> onStops;
    private final HashMap<String, RecorderClient> recorderClientCache;

    public AudioRecordCache() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AudioRecordCache(HashMap<String, RecorderClient> recorderClientCache, HashMap<String, BridgeCallback> onStarts, HashMap<String, BridgeCallback> onStops, HashMap<String, BridgeCallback> onPauses, HashMap<String, BridgeCallback> onResumes, HashMap<String, BridgeCallback> onErrors) {
        Intrinsics.h(recorderClientCache, "recorderClientCache");
        Intrinsics.h(onStarts, "onStarts");
        Intrinsics.h(onStops, "onStops");
        Intrinsics.h(onPauses, "onPauses");
        Intrinsics.h(onResumes, "onResumes");
        Intrinsics.h(onErrors, "onErrors");
        this.recorderClientCache = recorderClientCache;
        this.onStarts = onStarts;
        this.onStops = onStops;
        this.onPauses = onPauses;
        this.onResumes = onResumes;
        this.onErrors = onErrors;
    }

    public /* synthetic */ AudioRecordCache(HashMap hashMap, HashMap hashMap2, HashMap hashMap3, HashMap hashMap4, HashMap hashMap5, HashMap hashMap6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new HashMap() : hashMap, (i11 & 2) != 0 ? new HashMap() : hashMap2, (i11 & 4) != 0 ? new HashMap() : hashMap3, (i11 & 8) != 0 ? new HashMap() : hashMap4, (i11 & 16) != 0 ? new HashMap() : hashMap5, (i11 & 32) != 0 ? new HashMap() : hashMap6);
    }

    public static /* synthetic */ AudioRecordCache copy$default(AudioRecordCache audioRecordCache, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, HashMap hashMap4, HashMap hashMap5, HashMap hashMap6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hashMap = audioRecordCache.recorderClientCache;
        }
        if ((i11 & 2) != 0) {
            hashMap2 = audioRecordCache.onStarts;
        }
        HashMap hashMap7 = hashMap2;
        if ((i11 & 4) != 0) {
            hashMap3 = audioRecordCache.onStops;
        }
        HashMap hashMap8 = hashMap3;
        if ((i11 & 8) != 0) {
            hashMap4 = audioRecordCache.onPauses;
        }
        HashMap hashMap9 = hashMap4;
        if ((i11 & 16) != 0) {
            hashMap5 = audioRecordCache.onResumes;
        }
        HashMap hashMap10 = hashMap5;
        if ((i11 & 32) != 0) {
            hashMap6 = audioRecordCache.onErrors;
        }
        return audioRecordCache.copy(hashMap, hashMap7, hashMap8, hashMap9, hashMap10, hashMap6);
    }

    public final HashMap<String, RecorderClient> component1() {
        return this.recorderClientCache;
    }

    public final HashMap<String, BridgeCallback> component2() {
        return this.onStarts;
    }

    public final HashMap<String, BridgeCallback> component3() {
        return this.onStops;
    }

    public final HashMap<String, BridgeCallback> component4() {
        return this.onPauses;
    }

    public final HashMap<String, BridgeCallback> component5() {
        return this.onResumes;
    }

    public final HashMap<String, BridgeCallback> component6() {
        return this.onErrors;
    }

    public final AudioRecordCache copy(HashMap<String, RecorderClient> recorderClientCache, HashMap<String, BridgeCallback> onStarts, HashMap<String, BridgeCallback> onStops, HashMap<String, BridgeCallback> onPauses, HashMap<String, BridgeCallback> onResumes, HashMap<String, BridgeCallback> onErrors) {
        Intrinsics.h(recorderClientCache, "recorderClientCache");
        Intrinsics.h(onStarts, "onStarts");
        Intrinsics.h(onStops, "onStops");
        Intrinsics.h(onPauses, "onPauses");
        Intrinsics.h(onResumes, "onResumes");
        Intrinsics.h(onErrors, "onErrors");
        return new AudioRecordCache(recorderClientCache, onStarts, onStops, onPauses, onResumes, onErrors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioRecordCache)) {
            return false;
        }
        AudioRecordCache audioRecordCache = (AudioRecordCache) other;
        return Intrinsics.c(this.recorderClientCache, audioRecordCache.recorderClientCache) && Intrinsics.c(this.onStarts, audioRecordCache.onStarts) && Intrinsics.c(this.onStops, audioRecordCache.onStops) && Intrinsics.c(this.onPauses, audioRecordCache.onPauses) && Intrinsics.c(this.onResumes, audioRecordCache.onResumes) && Intrinsics.c(this.onErrors, audioRecordCache.onErrors);
    }

    public final HashMap<String, BridgeCallback> getOnErrors() {
        return this.onErrors;
    }

    public final HashMap<String, BridgeCallback> getOnPauses() {
        return this.onPauses;
    }

    public final HashMap<String, BridgeCallback> getOnResumes() {
        return this.onResumes;
    }

    public final HashMap<String, BridgeCallback> getOnStarts() {
        return this.onStarts;
    }

    public final HashMap<String, BridgeCallback> getOnStops() {
        return this.onStops;
    }

    public final HashMap<String, RecorderClient> getRecorderClientCache() {
        return this.recorderClientCache;
    }

    public int hashCode() {
        return (((((((((this.recorderClientCache.hashCode() * 31) + this.onStarts.hashCode()) * 31) + this.onStops.hashCode()) * 31) + this.onPauses.hashCode()) * 31) + this.onResumes.hashCode()) * 31) + this.onErrors.hashCode();
    }

    public String toString() {
        return "AudioRecordCache(recorderClientCache=" + this.recorderClientCache + ", onStarts=" + this.onStarts + ", onStops=" + this.onStops + ", onPauses=" + this.onPauses + ", onResumes=" + this.onResumes + ", onErrors=" + this.onErrors + ")";
    }
}
