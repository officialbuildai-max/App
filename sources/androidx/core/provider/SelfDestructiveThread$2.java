package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.l;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class SelfDestructiveThread$2 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ Callable val$callable;
    final /* synthetic */ Handler val$calleeHandler;
    final /* synthetic */ l.a val$reply;

    SelfDestructiveThread$2(l lVar, Callable callable, Handler handler, l.a aVar) {
        this.val$callable = callable;
        this.val$calleeHandler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        final Object obj;
        try {
            obj = this.val$callable.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.val$calleeHandler.post(new Runnable() { // from class: androidx.core.provider.SelfDestructiveThread$2.1
            @Override // java.lang.Runnable
            public void run() {
                SelfDestructiveThread$2.this.getClass();
                throw null;
            }
        });
    }
}
