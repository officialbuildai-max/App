package com.transsion.postdetail.ui.fragment.preload;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.viewmodel.ImmVideoRequestEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTvVideoImmersiveDataLoader extends qm.b {

    /* renamed from: f, reason: collision with root package name */
    private ImmVideoRequestEntity f49836f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f49837g;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortTvVideoImmersiveDataLoader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f49836f = immVideoRequestEntity;
        this.f49837g = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.preload.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.d q11;
                q11 = ShortTvVideoImmersiveDataLoader.q();
                return q11;
            }
        });
    }

    public /* synthetic */ ShortTvVideoImmersiveDataLoader(ImmVideoRequestEntity immVideoRequestEntity, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : immVideoRequestEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.d o() {
        return (xo.d) this.f49837g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(ShortTVRespData shortTVRespData, Continuation continuation) {
        Object m1185constructorimpl;
        Media video;
        Video videoAddress;
        String url;
        Unit unit;
        Media video2;
        Video videoAddress2;
        String url2;
        Object g11;
        ImmVideoRequestEntity immVideoRequestEntity = this.f49836f;
        Unit unit2 = null;
        if (!Intrinsics.c(immVideoRequestEntity != null ? immVideoRequestEntity.getPage() : null, "1")) {
            return Unit.f67184a;
        }
        List<Subject> items = shortTVRespData != null ? shortTVRespData.getItems() : null;
        if (items == null || items.isEmpty()) {
            return Unit.f67184a;
        }
        if (ap.b.f16171a.b()) {
            Intrinsics.e(shortTVRespData);
            List<Subject> items2 = shortTVRespData.getItems();
            Intrinsics.e(items2);
            ShortTVItem shortTVFirstEp = items2.get(0).getShortTVFirstEp();
            if (shortTVFirstEp != null && (g11 = i.g(y0.c(), new ShortTvVideoImmersiveDataLoader$initVideoPreload$2$1(shortTVFirstEp, null), continuation)) == IntrinsicsKt.f()) {
                return g11;
            }
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.e(shortTVRespData);
                List<Subject> items3 = shortTVRespData.getItems();
                Intrinsics.e(items3);
                ShortTVItem shortTVFirstEp2 = items3.get(0).getShortTVFirstEp();
                if (shortTVFirstEp2 == null || (video2 = shortTVFirstEp2.getVideo()) == null || (videoAddress2 = video2.getVideoAddress()) == null || (url2 = videoAddress2.getUrl()) == null) {
                    unit = null;
                } else {
                    ORPlayerPreloadManager.f48463i.a().i(url2);
                    unit = Unit.f67184a;
                }
                Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            try {
                Intrinsics.e(shortTVRespData);
                List<Subject> items4 = shortTVRespData.getItems();
                Intrinsics.e(items4);
                ShortTVItem shortTVFirstEp3 = items4.get(1).getShortTVFirstEp();
                if (shortTVFirstEp3 != null && (video = shortTVFirstEp3.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                    ORPlayerPreloadManager.f48463i.a().i(url);
                    unit2 = Unit.f67184a;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit2);
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th3));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.d q() {
        return (xo.d) zg.c.f79537e.a().h(xo.d.class);
    }

    @Override // qm.b
    public void h(b0 b0Var) {
        t1 d11;
        d11 = k.d(o0.a(y0.b()), null, null, new ShortTvVideoImmersiveDataLoader$loadDataFromService$1(this, null), 3, null);
        j(d11);
    }

    public final ImmVideoRequestEntity n() {
        return this.f49836f;
    }

    public final void r(ImmVideoRequestEntity immVideoRequestEntity) {
        this.f49836f = immVideoRequestEntity;
    }
}
