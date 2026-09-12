package com.transsion.ugcvideodetail.hepler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f56482a = new g();

    /* loaded from: classes6.dex */
    public static final class a implements sj.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f56483a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UGCVideoDetailViewModel f56484b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f56485c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f56486d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f56487e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f56488f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Boolean f56489g;

        a(Function1 function1, UGCVideoDetailViewModel uGCVideoDetailViewModel, String str, String str2, String str3, String str4, Boolean bool) {
            this.f56483a = function1;
            this.f56484b = uGCVideoDetailViewModel;
            this.f56485c = str;
            this.f56486d = str2;
            this.f56487e = str3;
            this.f56488f = str4;
            this.f56489g = bool;
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            String ugcVideoId;
            Function1 function1 = this.f56483a;
            UGCVideoDetailViewModel uGCVideoDetailViewModel = this.f56484b;
            String str = this.f56485c;
            String str2 = this.f56486d;
            String str3 = this.f56487e;
            String str4 = this.f56488f;
            Boolean bool = this.f56489g;
            try {
                Result.Companion companion = Result.INSTANCE;
                UGCVideo uGCVideo = (UGCVideo) function1.invoke(Integer.valueOf(i11));
                if (uGCVideo != null && (ugcVideoId = uGCVideo.getUgcVideoId()) != null && !uGCVideoDetailViewModel.a0(ugcVideoId)) {
                    uGCVideoDetailViewModel.e0(ugcVideoId);
                    if (str != null) {
                        h.f56490a.g(str, uGCVideo, i11, j11, str2, str3, str4, bool);
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    private g() {
    }

    public final sj.b a(RecyclerView recyclerView, UGCVideoDetailViewModel viewModel, String str, Function1 getItemAtPosition, String str2, String str3, String str4, Boolean bool) {
        Intrinsics.h(recyclerView, "recyclerView");
        Intrinsics.h(viewModel, "viewModel");
        Intrinsics.h(getItemAtPosition, "getItemAtPosition");
        sj.b bVar = new sj.b(0.6f, new a(getItemAtPosition, viewModel, str, str2, str3, str4, bool), false, 4, null);
        bVar.n(2);
        recyclerView.addOnScrollListener(bVar);
        return bVar;
    }

    public final void c(UGCVideo uGCVideo, int i11, String str, String str2, String str3, String str4) {
        if (uGCVideo == null || str == null) {
            return;
        }
        h.f56490a.f(str, uGCVideo, i11, str2, str3, str4);
    }
}
