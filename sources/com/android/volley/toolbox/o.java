package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.toolbox.c;
import java.io.File;

/* loaded from: classes2.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements c.InterfaceC0185c {

        /* renamed from: a, reason: collision with root package name */
        private File f19392a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f19393b;

        a(Context context) {
            this.f19393b = context;
        }

        @Override // com.android.volley.toolbox.c.InterfaceC0185c
        public File get() {
            if (this.f19392a == null) {
                this.f19392a = new File(this.f19393b.getCacheDir(), "volley");
            }
            return this.f19392a;
        }
    }

    public static com.android.volley.h a(Context context) {
        return c(context, null);
    }

    private static com.android.volley.h b(Context context, com.android.volley.f fVar) {
        com.android.volley.h hVar = new com.android.volley.h(new c(new a(context.getApplicationContext())), fVar);
        hVar.g();
        return hVar;
    }

    public static com.android.volley.h c(Context context, com.android.volley.toolbox.a aVar) {
        return b(context, aVar == null ? new b(new g()) : new b(aVar));
    }
}
