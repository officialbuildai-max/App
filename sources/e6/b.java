package e6;

import android.content.Context;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import java.util.concurrent.ConcurrentHashMap;
import v5.a;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f61674a = new ConcurrentHashMap();

    public static synchronized void a(Context context, TKC tkc, a.InterfaceC0973a interfaceC0973a) {
        synchronized (b.class) {
            if (tkc == null) {
                return;
            }
            try {
                ConcurrentHashMap concurrentHashMap = f61674a;
                c cVar = (c) concurrentHashMap.get(tkc.sef());
                if (cVar == null) {
                    cVar = new c(context, tkc);
                    concurrentHashMap.put(tkc.sef(), cVar);
                    tkc.TKC();
                    tkc.sef();
                }
                cVar.m(interfaceC0973a);
                tkc.TKC();
                tkc.sef();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized void b(TKC tkc) {
        synchronized (b.class) {
            try {
                c cVar = (c) f61674a.remove(tkc.sef());
                if (cVar != null) {
                    cVar.n(true);
                }
                tkc.TKC();
                tkc.sef();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
