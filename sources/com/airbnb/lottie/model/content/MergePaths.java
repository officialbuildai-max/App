package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.h;
import m4.l;
import r4.c;
import v4.f;

/* loaded from: classes.dex */
public class MergePaths implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f17870a;

    /* renamed from: b, reason: collision with root package name */
    private final MergePathsMode f17871b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17872c;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i11) {
            return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f17870a = str;
        this.f17871b = mergePathsMode;
        this.f17872c = z10;
    }

    @Override // r4.c
    public m4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        if (lottieDrawable.n0(LottieFeatureFlag.MergePathsApi19)) {
            return new l(this);
        }
        f.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f17871b;
    }

    public String c() {
        return this.f17870a;
    }

    public boolean d() {
        return this.f17872c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f17871b + '}';
    }
}
