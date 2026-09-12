package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static int f7324f = -1;

    /* renamed from: a, reason: collision with root package name */
    int f7325a;

    /* renamed from: b, reason: collision with root package name */
    int f7326b;

    /* renamed from: c, reason: collision with root package name */
    String f7327c;

    /* renamed from: d, reason: collision with root package name */
    protected int f7328d;

    /* renamed from: e, reason: collision with root package name */
    HashMap f7329e;

    public d() {
        int i11 = f7324f;
        this.f7325a = i11;
        this.f7326b = i11;
        this.f7327c = null;
    }

    public abstract void a(HashMap hashMap);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract d clone();

    public d c(d dVar) {
        this.f7325a = dVar.f7325a;
        this.f7326b = dVar.f7326b;
        this.f7327c = dVar.f7327c;
        this.f7328d = dVar.f7328d;
        this.f7329e = dVar.f7329e;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(HashSet hashSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str) {
        String str2 = this.f7327c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i11) {
        this.f7325a = i11;
    }

    public void h(HashMap hashMap) {
    }

    public d i(int i11) {
        this.f7326b = i11;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
