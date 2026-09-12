package com.cloud.tmc.miniapp.ui;

import com.cloud.tmc.integration.utils.share.OnShareListener;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.task.OooO00o;
import com.cloud.tmc.miniapp.task.OooO0O0;
import com.cloud.tmc.miniapp.utils.toast.ToastUtils;

/* loaded from: classes3.dex */
public final class ImagePreviewActivity$systemShare$1 implements OnShareListener {
    public final /* synthetic */ ImagePreviewActivity this$0;

    public ImagePreviewActivity$systemShare$1(ImagePreviewActivity imagePreviewActivity) {
        this.this$0 = imagePreviewActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShare$lambda$0() {
        ToastUtils.showToast$default(R.string.mini_image_select_shared_success, 0, 0L, false, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShare$lambda$1() {
        ToastUtils.showToast$default(R.string.mini_image_select_shared_failed, 0, 0L, false, 14, null);
    }

    @Override // com.cloud.tmc.integration.utils.share.OnShareListener
    public void onShare(int i11, int i12) {
        OooO0O0 mTaskQueue;
        OooO0O0 mTaskQueue2;
        if (i12 == 1) {
            TmcLogger.d("ImagePreviewActivity", "Share file successfully");
            mTaskQueue2 = this.this$0.getMTaskQueue();
            mTaskQueue2.OooO00o(new OooO00o("share", new Runnable() { // from class: com.cloud.tmc.miniapp.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    ImagePreviewActivity$systemShare$1.onShare$lambda$0();
                }
            }));
        } else {
            TmcLogger.d("ImagePreviewActivity", "Share file failed");
            mTaskQueue = this.this$0.getMTaskQueue();
            mTaskQueue.OooO00o(new OooO00o("share", new Runnable() { // from class: com.cloud.tmc.miniapp.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    ImagePreviewActivity$systemShare$1.onShare$lambda$1();
                }
            }));
        }
    }
}
