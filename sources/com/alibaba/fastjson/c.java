package com.alibaba.fastjson;

import a5.j1;
import a5.m0;
import a5.o0;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class c implements m0 {

    /* renamed from: c, reason: collision with root package name */
    public static String f18224c = "/**/";

    /* renamed from: a, reason: collision with root package name */
    private String f18225a;

    /* renamed from: b, reason: collision with root package name */
    private final List f18226b = new ArrayList();

    public c() {
    }

    public c(String str) {
        this.f18225a = str;
    }

    @Override // a5.m0
    public void a(o0 o0Var, Object obj, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        int i12 = SerializerFeature.BrowserSecure.mask;
        if ((i11 & i12) != 0 || j1Var.p(i12)) {
            j1Var.write(f18224c);
        }
        j1Var.write(this.f18225a);
        j1Var.write(40);
        for (int i13 = 0; i13 < this.f18226b.size(); i13++) {
            if (i13 != 0) {
                j1Var.write(44);
            }
            o0Var.A(this.f18226b.get(i13));
        }
        j1Var.write(41);
    }

    public void b(Object obj) {
        this.f18226b.add(obj);
    }

    public String toString() {
        return a.toJSONString(this);
    }
}
