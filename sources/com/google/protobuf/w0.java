package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.f0;
import com.google.protobuf.t;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class w0 implements i1 {
    private final s0 defaultInstance;
    private final p extensionSchema;
    private final boolean hasExtensions;
    private final o1 unknownFieldSchema;

    private w0(o1 o1Var, p pVar, s0 s0Var) {
        this.unknownFieldSchema = o1Var;
        this.hasExtensions = pVar.hasExtensions(s0Var);
        this.extensionSchema = pVar;
        this.defaultInstance = s0Var;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(o1 o1Var, Object obj) {
        return o1Var.getSerializedSizeAsMessageSet(o1Var.getFromMessage(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends t.c> void mergeFromHelper(o1 o1Var, p pVar, Object obj, h1 h1Var, o oVar) throws IOException {
        Object builderFromMessage = o1Var.getBuilderFromMessage(obj);
        t mutableExtensions = pVar.getMutableExtensions(obj);
        do {
            try {
                if (h1Var.getFieldNumber() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                o1Var.setBuilderToMessage(obj, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(h1Var, oVar, pVar, mutableExtensions, o1Var, builderFromMessage));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> w0 newSchema(o1 o1Var, p pVar, s0 s0Var) {
        return new w0(o1Var, pVar, s0Var);
    }

    private <UT, UB, ET extends t.c> boolean parseMessageSetItemOrUnknownField(h1 h1Var, o oVar, p pVar, t tVar, o1 o1Var, UB ub2) throws IOException {
        int tag = h1Var.getTag();
        int i11 = 0;
        if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) {
            if (WireFormat.getTagWireType(tag) != 2) {
                return h1Var.skipField();
            }
            Object findExtensionByNumber = pVar.findExtensionByNumber(oVar, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (findExtensionByNumber == null) {
                return o1Var.mergeOneFieldFrom(ub2, h1Var, 0);
            }
            pVar.parseLengthPrefixedMessageSetItem(h1Var, findExtensionByNumber, oVar, tVar);
            return true;
        }
        Object obj = null;
        ByteString byteString = null;
        while (h1Var.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = h1Var.getTag();
            if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                i11 = h1Var.readUInt32();
                obj = pVar.findExtensionByNumber(oVar, this.defaultInstance, i11);
            } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (obj != null) {
                    pVar.parseLengthPrefixedMessageSetItem(h1Var, obj, oVar, tVar);
                } else {
                    byteString = h1Var.readBytes();
                }
            } else if (!h1Var.skipField()) {
                break;
            }
        }
        if (h1Var.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (byteString != null) {
            if (obj != null) {
                pVar.parseMessageSetItem(byteString, obj, oVar, tVar);
            } else {
                o1Var.addLengthDelimited(ub2, i11, byteString);
            }
        }
        return true;
    }

    private <UT, UB> void writeUnknownFieldsHelper(o1 o1Var, Object obj, Writer writer) throws IOException {
        o1Var.writeAsMessageSetTo(o1Var.getFromMessage(obj), writer);
    }

    @Override // com.google.protobuf.i1
    public boolean equals(Object obj, Object obj2) {
        if (!this.unknownFieldSchema.getFromMessage(obj).equals(this.unknownFieldSchema.getFromMessage(obj2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(obj).equals(this.extensionSchema.getExtensions(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.i1
    public int getSerializedSize(Object obj) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, obj);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(obj).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.i1
    public int hashCode(Object obj) {
        int hashCode = this.unknownFieldSchema.getFromMessage(obj).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(obj).hashCode() : hashCode;
    }

    @Override // com.google.protobuf.i1
    public final boolean isInitialized(Object obj) {
        return this.extensionSchema.getExtensions(obj).isInitialized();
    }

    @Override // com.google.protobuf.i1
    public void makeImmutable(Object obj) {
        this.unknownFieldSchema.makeImmutable(obj);
        this.extensionSchema.makeImmutable(obj);
    }

    @Override // com.google.protobuf.i1
    public void mergeFrom(Object obj, h1 h1Var, o oVar) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, obj, h1Var, oVar);
    }

    @Override // com.google.protobuf.i1
    public void mergeFrom(Object obj, Object obj2) {
        k1.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
        if (this.hasExtensions) {
            k1.mergeExtensions(this.extensionSchema, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb A[EDGE_INSN: B:24:0x00cb->B:25:0x00cb BREAK  A[LOOP:1: B:10:0x006d->B:18:0x006d], SYNTHETIC] */
    @Override // com.google.protobuf.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mergeFrom(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.protobuf.e.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.p1 r1 = r0.unknownFields
            com.google.protobuf.p1 r2 = com.google.protobuf.p1.getDefaultInstance()
            if (r1 != r2) goto L11
            com.google.protobuf.p1 r1 = com.google.protobuf.p1.newInstance()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.GeneratedMessageLite$d r11 = (com.google.protobuf.GeneratedMessageLite.d) r11
            com.google.protobuf.t r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.e.decodeVarint32(r12, r13, r15)
            int r13 = r15.int1
            int r3 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.p r2 = r10.extensionSchema
            com.google.protobuf.o r3 = r15.extensionRegistry
            com.google.protobuf.s0 r5 = r10.defaultInstance
            int r6 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.findExtensionByNumber(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$g r8 = (com.google.protobuf.GeneratedMessageLite.g) r8
            if (r8 == 0) goto L5c
            com.google.protobuf.d1 r13 = com.google.protobuf.d1.getInstance()
            com.google.protobuf.s0 r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.i1 r13 = r13.schemaFor(r2)
            int r13 = com.google.protobuf.e.decodeMessageField(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$f r2 = r8.descriptor
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
        L5a:
            r2 = r8
            goto L19
        L5c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.e.decodeUnknownField(r2, r3, r4, r5, r6, r7)
            goto L5a
        L66:
            int r13 = com.google.protobuf.e.skipField(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.e.decodeVarint32(r12, r4, r15)
            int r6 = r15.int1
            int r7 = com.google.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.d1 r6 = com.google.protobuf.d1.getInstance()
            com.google.protobuf.s0 r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.i1 r6 = r6.schemaFor(r7)
            int r4 = com.google.protobuf.e.decodeMessageField(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$f r6 = r2.descriptor
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.e.decodeBytes(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.e.decodeVarint32(r12, r4, r15)
            int r13 = r15.int1
            com.google.protobuf.p r2 = r10.extensionSchema
            com.google.protobuf.o r6 = r15.extensionRegistry
            com.google.protobuf.s0 r7 = r10.defaultInstance
            java.lang.Object r2 = r2.findExtensionByNumber(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$g r2 = (com.google.protobuf.GeneratedMessageLite.g) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_END_TAG
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.e.skipField(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.WireFormat.makeTag(r13, r5)
            r1.storeField(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.w0.mergeFrom(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):void");
    }

    @Override // com.google.protobuf.i1
    public Object newInstance() {
        s0 s0Var = this.defaultInstance;
        return s0Var instanceof GeneratedMessageLite ? ((GeneratedMessageLite) s0Var).newMutableInstance() : s0Var.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.i1
    public void writeTo(Object obj, Writer writer) throws IOException {
        Iterator<Map.Entry<t.c, Object>> it = this.extensionSchema.getExtensions(obj).iterator();
        while (it.hasNext()) {
            Map.Entry<t.c, Object> next = it.next();
            t.c key = next.getKey();
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof f0.b) {
                writer.writeMessageSetItem(key.getNumber(), ((f0.b) next).getField().toByteString());
            } else {
                writer.writeMessageSetItem(key.getNumber(), next.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, obj, writer);
    }
}
