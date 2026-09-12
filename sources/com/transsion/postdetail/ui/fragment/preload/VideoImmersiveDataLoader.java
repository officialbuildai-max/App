package com.transsion.postdetail.ui.fragment.preload;

import androidx.view.b0;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class VideoImmersiveDataLoader extends qm.b {

    /* renamed from: f, reason: collision with root package name */
    private ImmVideoRequestEntity f49842f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f49843g;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoImmersiveDataLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public VideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f49842f = immVideoRequestEntity;
        this.f49843g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.b o11;
                o11 = VideoImmersiveDataLoader.o();
                return o11;
            }
        });
    }

    public /* synthetic */ VideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : immVideoRequestEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b n() {
        return (xo.b) this.f49843g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b o() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    @Override // qm.b
    public void h(b0 b0Var) {
        t1 d11;
        d11 = k.d(o0.a(y0.b()), null, null, new VideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, null);
        j(d11);
    }

    public final ImmVideoRequestEntity m() {
        return this.f49842f;
    }
}
