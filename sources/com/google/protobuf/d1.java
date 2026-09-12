package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d1 {
    private static final d1 INSTANCE = new d1();
    private final ConcurrentMap<Class<?>, i1> schemaCache = new ConcurrentHashMap();
    private final j1 schemaFactory = new l0();

    private d1() {
    }

    public static d1 getInstance() {
        return INSTANCE;
    }

    int getTotalSchemaSize() {
        int i11 = 0;
        for (i1 i1Var : this.schemaCache.values()) {
            if (i1Var instanceof v0) {
                i11 += ((v0) i1Var).getSchemaSize();
            }
        }
        return i11;
    }

    <T> boolean isInitialized(T t11) {
        return schemaFor((d1) t11).isInitialized(t11);
    }

    public <T> void makeImmutable(T t11) {
        schemaFor((d1) t11).makeImmutable(t11);
    }

    public <T> void mergeFrom(T t11, h1 h1Var) throws IOException {
        mergeFrom(t11, h1Var, o.getEmptyRegistry());
    }

    public <T> void mergeFrom(T t11, h1 h1Var, o oVar) throws IOException {
        schemaFor((d1) t11).mergeFrom(t11, h1Var, oVar);
    }

    public i1 registerSchema(Class<?> cls, i1 i1Var) {
        y.checkNotNull(cls, "messageType");
        y.checkNotNull(i1Var, "schema");
        return this.schemaCache.putIfAbsent(cls, i1Var);
    }

    public i1 registerSchemaOverride(Class<?> cls, i1 i1Var) {
        y.checkNotNull(cls, "messageType");
        y.checkNotNull(i1Var, "schema");
        return this.schemaCache.put(cls, i1Var);
    }

    public <T> i1 schemaFor(Class<T> cls) {
        y.checkNotNull(cls, "messageType");
        i1 i1Var = this.schemaCache.get(cls);
        if (i1Var != null) {
            return i1Var;
        }
        i1 createSchema = this.schemaFactory.createSchema(cls);
        i1 registerSchema = registerSchema(cls, createSchema);
        return registerSchema != null ? registerSchema : createSchema;
    }

    public <T> i1 schemaFor(T t11) {
        return schemaFor((Class) t11.getClass());
    }

    public <T> void writeTo(T t11, Writer writer) throws IOException {
        schemaFor((d1) t11).writeTo(t11, writer);
    }
}
