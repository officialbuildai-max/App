package com.transsion.postdetail.util;

import android.app.Application;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$string;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.PostSaveHelper$downloadVideo$1", f = "PostSaveHelper.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PostSaveHelper$downloadVideo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostSubjectItem $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostSaveHelper$downloadVideo$1(PostSubjectItem postSubjectItem, Continuation<? super PostSaveHelper$downloadVideo$1> continuation) {
        super(2, continuation);
        this.$item = postSubjectItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostSaveHelper$downloadVideo$1(this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PostSaveHelper$downloadVideo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Media media;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (!nh.m.f70597a.e()) {
                uh.b.f76876a.d(R$string.no_network_toast);
                return Unit.f67184a;
            }
            uh.b.f76876a.d(com.transsion.baseui.R$string.post_start_saving);
            PostSubjectItem postSubjectItem = this.$item;
            Video a11 = u.a((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getVideo());
            if (a11 == null || (str = a11.getUrl()) == null) {
                str = "";
            }
            String str2 = "MB_" + System.currentTimeMillis() + ".mp4";
            VideoSaver videoSaver = VideoSaver.f50212a;
            Application a12 = Utils.a();
            Intrinsics.g(a12, "getApp(...)");
            this.label = 1;
            obj = videoSaver.c(a12, str, str2, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Uri) obj) != null) {
            uh.b.f76876a.d(com.transsion.baseui.R$string.post_saved_to_gallery);
        }
        return Unit.f67184a;
    }
}
