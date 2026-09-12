package com.cloud.tmc.miniapp.performanceanalyse.page;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class OooO00o {
    public final String OooO00o;
    public String OooO0O0;
    public final Map<String, Long> OooO0OO;
    public final Map<String, Long> OooO0Oo;
    public boolean OooO0o;
    public final Map<String, Long> OooO0o0;
    public boolean OooO0oO;
    public boolean OooO0oo;

    public OooO00o(String pagePath, String pageId, Map<String, Long> stageStartMap, Map<String, Long> stageEndMap, Map<String, Long> stageTime, boolean z10, boolean z11, boolean z12) {
        Intrinsics.h(pagePath, "pagePath");
        Intrinsics.h(pageId, "pageId");
        Intrinsics.h(stageStartMap, "stageStartMap");
        Intrinsics.h(stageEndMap, "stageEndMap");
        Intrinsics.h(stageTime, "stageTime");
        this.OooO00o = pagePath;
        this.OooO0O0 = pageId;
        this.OooO0OO = stageStartMap;
        this.OooO0Oo = stageEndMap;
        this.OooO0o0 = stageTime;
        this.OooO0o = z10;
        this.OooO0oO = z11;
        this.OooO0oo = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO00o)) {
            return false;
        }
        OooO00o oooO00o = (OooO00o) obj;
        return Intrinsics.c(this.OooO00o, oooO00o.OooO00o) && Intrinsics.c(this.OooO0O0, oooO00o.OooO0O0) && Intrinsics.c(this.OooO0OO, oooO00o.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO00o.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooO00o.OooO0o0) && this.OooO0o == oooO00o.OooO0o && this.OooO0oO == oooO00o.OooO0oO && this.OooO0oo == oooO00o.OooO0oo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((this.OooO0O0.hashCode() + (this.OooO00o.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z10 = this.OooO0o;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode + i11) * 31;
        boolean z11 = this.OooO0oO;
        int i13 = z11;
        if (z11 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        boolean z12 = this.OooO0oo;
        return i14 + (z12 ? 1 : z12 ? 1 : 0);
    }

    public String toString() {
        return "PageOpenPointData(pagePath=" + this.OooO00o + ", pageId=" + this.OooO0O0 + ", stageStartMap=" + this.OooO0OO + ", stageEndMap=" + this.OooO0Oo + ", stageTime=" + this.OooO0o0 + ", isHomePage=" + this.OooO0o + ", isReportFail=" + this.OooO0oO + ", isPageOpenSuccessed=" + this.OooO0oo + ")";
    }
}
