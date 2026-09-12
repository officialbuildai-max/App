package com.google.firebase.encoders.proto;

import bc.d;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.proto.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map f31886a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f31887b;

    /* renamed from: c, reason: collision with root package name */
    private final bc.c f31888c;

    /* loaded from: classes4.dex */
    public static final class a implements cc.b {

        /* renamed from: d, reason: collision with root package name */
        private static final bc.c f31889d = new bc.c() { // from class: ec.b
            @Override // bc.c
            public final void a(Object obj, Object obj2) {
                e.a.e(obj, (d) obj2);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final Map f31890a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map f31891b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private bc.c f31892c = f31889d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, bc.d dVar) {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public e c() {
            return new e(new HashMap(this.f31890a), new HashMap(this.f31891b), this.f31892c);
        }

        public a d(cc.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // cc.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, bc.c cVar) {
            this.f31890a.put(cls, cVar);
            this.f31891b.remove(cls);
            return this;
        }
    }

    e(Map map, Map map2, bc.c cVar) {
        this.f31886a = map;
        this.f31887b = map2;
        this.f31888c = cVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new d(outputStream, this.f31886a, this.f31887b, this.f31888c).t(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
