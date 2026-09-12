package xc;

import android.content.Context;
import mb.r;

/* loaded from: classes5.dex */
public abstract class h {

    /* loaded from: classes5.dex */
    public interface a {
        String a(Object obj);
    }

    public static mb.c b(String str, String str2) {
        return mb.c.l(f.a(str, str2), f.class);
    }

    public static mb.c c(final String str, final a aVar) {
        return mb.c.m(f.class).b(r.k(Context.class)).f(new mb.h() { // from class: xc.g
            @Override // mb.h
            public final Object a(mb.e eVar) {
                f d11;
                d11 = h.d(str, aVar, eVar);
                return d11;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f d(String str, a aVar, mb.e eVar) {
        return f.a(str, aVar.a((Context) eVar.a(Context.class)));
    }
}
