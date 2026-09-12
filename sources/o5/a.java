package o5;

import android.content.Context;
import java.util.Calendar;
import q5.c;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private p5.a f70860a;

    public a(Context context, c cVar) {
        p5.a aVar = new p5.a(2);
        this.f70860a = aVar;
        aVar.C = context;
        aVar.f72429a = cVar;
    }

    public com.bigkoo.pickerview.view.a a() {
        return new com.bigkoo.pickerview.view.a(this.f70860a);
    }

    public a b(int i11) {
        this.f70860a.Q = i11;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        p5.a aVar = this.f70860a;
        aVar.f72442n = str;
        aVar.f72443o = str2;
        aVar.f72444p = str3;
        aVar.f72445q = str4;
        aVar.f72446r = str5;
        aVar.f72447s = str6;
        return this;
    }

    public a d(Calendar calendar, Calendar calendar2) {
        p5.a aVar = this.f70860a;
        aVar.f72436h = calendar;
        aVar.f72437i = calendar2;
        return this;
    }

    public a e(int i11) {
        this.f70860a.P = i11;
        return this;
    }

    public a f(int i11) {
        this.f70860a.O = i11;
        return this;
    }
}
