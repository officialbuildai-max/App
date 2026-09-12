package com.google.protobuf;

import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int extensionNumber(Map.Entry<?, ?> entry);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object findExtensionByNumber(o oVar, s0 s0Var, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract t getExtensions(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract t getMutableExtensions(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasExtensions(s0 s0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <UT, UB> UB parseExtension(Object obj, h1 h1Var, Object obj2, o oVar, t tVar, UB ub2, o1 o1Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void parseLengthPrefixedMessageSetItem(h1 h1Var, Object obj, o oVar, t tVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void parseMessageSetItem(ByteString byteString, Object obj, o oVar, t tVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException;

    abstract void setExtensions(Object obj, t tVar);
}
