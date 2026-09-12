package com.transsion.postdetail.ui.fragment.preload;

import androidx.view.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class VideoDataLoader extends qm.b {

    /* renamed from: f, reason: collision with root package name */
    private String f49839f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f49840g;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoDataLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VideoDataLoader(String postId) {
        Intrinsics.h(postId, "postId");
        this.f49839f = postId;
        this.f49840g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.b o11;
                o11 = VideoDataLoader.o();
                return o11;
            }
        });
    }

    public /* synthetic */ VideoDataLoader(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b n() {
        return (xo.b) this.f49840g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b o() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    @Override // qm.b
    public void h(b0 b0Var) {
        t1 d11;
        d11 = k.d(o0.a(y0.b()), null, null, new VideoDataLoader$loadDataFromService$1(this, null), 3, null);
        j(d11);
    }

    public final String m() {
        return this.f49839f;
    }

    public final void p(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f49839f = str;
    }
}
