package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.f;
import androidx.compose.ui.text.g0;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap f6411a = new WeakHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final WeakHashMap f6412b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f6413c = new WeakHashMap();

    public final ClickableSpan a(AnnotatedString.c cVar) {
        WeakHashMap weakHashMap = this.f6413c;
        Object obj = weakHashMap.get(cVar);
        if (obj == null) {
            obj = new h((androidx.compose.ui.text.f) cVar.e());
            weakHashMap.put(cVar, obj);
        }
        return (ClickableSpan) obj;
    }

    public final URLSpan b(AnnotatedString.c cVar) {
        WeakHashMap weakHashMap = this.f6412b;
        Object obj = weakHashMap.get(cVar);
        if (obj == null) {
            obj = new URLSpan(((f.b) cVar.e()).c());
            weakHashMap.put(cVar, obj);
        }
        return (URLSpan) obj;
    }

    public final URLSpan c(g0 g0Var) {
        WeakHashMap weakHashMap = this.f6411a;
        Object obj = weakHashMap.get(g0Var);
        if (obj == null) {
            obj = new URLSpan(g0Var.a());
            weakHashMap.put(g0Var, obj);
        }
        return (URLSpan) obj;
    }
}
