package androidx.loader.app;

import android.os.Bundle;
import androidx.view.u;
import androidx.view.y0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0092a {
        androidx.loader.content.a onCreateLoader(int i11, Bundle bundle);

        void onLoadFinished(androidx.loader.content.a aVar, Object obj);

        void onLoaderReset(androidx.loader.content.a aVar);
    }

    public static a b(u uVar) {
        return new b(uVar, ((y0) uVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract androidx.loader.content.a c(int i11, Bundle bundle, InterfaceC0092a interfaceC0092a);

    public abstract void d();
}
