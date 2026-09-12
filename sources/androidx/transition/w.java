package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    public View f15192b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f15191a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f15193c = new ArrayList();

    @Deprecated
    public w() {
    }

    public w(View view) {
        this.f15192b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f15192b == wVar.f15192b && this.f15191a.equals(wVar.f15191a);
    }

    public int hashCode() {
        return (this.f15192b.hashCode() * 31) + this.f15191a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f15192b + "\n") + "    values:";
        for (String str2 : this.f15191a.keySet()) {
            str = str + "    " + str2 + ": " + this.f15191a.get(str2) + "\n";
        }
        return str;
    }
}
