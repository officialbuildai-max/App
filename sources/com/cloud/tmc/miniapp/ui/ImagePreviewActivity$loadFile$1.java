package com.cloud.tmc.miniapp.ui;

import com.cloud.tmc.integration.utils.ext.FileExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ui.adapter.ImagePreviewAdapter;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

@DebugMetadata(c = "com.cloud.tmc.miniapp.ui.ImagePreviewActivity$loadFile$1", f = "ImagePreviewActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ImagePreviewActivity$loadFile$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1<File, Unit> $block;
    public final /* synthetic */ String $imagePath;
    public int label;
    public final /* synthetic */ ImagePreviewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImagePreviewActivity$loadFile$1(ImagePreviewActivity imagePreviewActivity, String str, Function1<? super File, Unit> function1, Continuation<? super ImagePreviewActivity$loadFile$1> continuation) {
        super(2, continuation);
        this.this$0 = imagePreviewActivity;
        this.$imagePath = str;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePreviewActivity$loadFile$1(this.this$0, this.$imagePath, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ImagePreviewActivity$loadFile$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ImagePreviewAdapter adapter;
        File loadImgFile;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            adapter = this.this$0.getAdapter();
            loadImgFile = adapter.getImageLoder().loadImgFile(this.this$0, this.$imagePath);
        } catch (Throwable th2) {
            TmcLogger.e("ImagePreviewActivity", th2);
            this.$block.invoke(null);
        }
        if (loadImgFile == null) {
            this.$block.invoke(null);
            return Unit.f67184a;
        }
        String d12 = StringsKt.d1(StringsKt.n1(this.$imagePath).toString(), "/", "");
        if (StringsKt.c1(d12, '.', "").length() == 0) {
            d12 = "IMG_" + System.currentTimeMillis() + ".png";
        }
        File file = new File(new File(this.this$0.getCacheDir(), "downloadFile"), d12);
        if (file.exists()) {
            FileExtKt.getDelete(file);
        }
        boolean moveTo$default = FileExtKt.moveTo$default(loadImgFile, file, false, false, 6, null);
        Function1<File, Unit> function1 = this.$block;
        if (!moveTo$default) {
            file = null;
        }
        function1.invoke(file);
        return Unit.f67184a;
    }
}
