package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class q extends p {

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.f) entry.getKey()).getNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public Object findExtensionByNumber(o oVar, s0 s0Var, int i11) {
        return oVar.findLiteExtensionByNumber(s0Var, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public t getExtensions(Object obj) {
        return ((GeneratedMessageLite.d) obj).extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public t getMutableExtensions(Object obj) {
        return ((GeneratedMessageLite.d) obj).ensureExtensionsAreMutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public boolean hasExtensions(s0 s0Var) {
        return s0Var instanceof GeneratedMessageLite.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public <UT, UB> UB parseExtension(Object obj, h1 h1Var, Object obj2, o oVar, t tVar, UB ub2, o1 o1Var) throws IOException {
        Object valueOf;
        Object field;
        ArrayList arrayList;
        GeneratedMessageLite.g gVar = (GeneratedMessageLite.g) obj2;
        int number = gVar.getNumber();
        if (gVar.descriptor.isRepeated() && gVar.descriptor.isPacked()) {
            switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[gVar.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    h1Var.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    h1Var.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    h1Var.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    h1Var.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    h1Var.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    h1Var.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    h1Var.readFixed32List(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    h1Var.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    h1Var.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    h1Var.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    h1Var.readSFixed64List(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    h1Var.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    h1Var.readSInt64List(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    h1Var.readEnumList(arrayList);
                    ub2 = (UB) k1.filterUnknownEnumList(obj, number, arrayList, gVar.descriptor.getEnumType(), ub2, o1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + gVar.descriptor.getLiteType());
            }
            tVar.setField(gVar.descriptor, arrayList);
        } else {
            if (gVar.getLiteType() != WireFormat.FieldType.ENUM) {
                switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[gVar.getLiteType().ordinal()]) {
                    case 1:
                        valueOf = Double.valueOf(h1Var.readDouble());
                        break;
                    case 2:
                        valueOf = Float.valueOf(h1Var.readFloat());
                        break;
                    case 3:
                        valueOf = Long.valueOf(h1Var.readInt64());
                        break;
                    case 4:
                        valueOf = Long.valueOf(h1Var.readUInt64());
                        break;
                    case 5:
                        valueOf = Integer.valueOf(h1Var.readInt32());
                        break;
                    case 6:
                        valueOf = Long.valueOf(h1Var.readFixed64());
                        break;
                    case 7:
                        valueOf = Integer.valueOf(h1Var.readFixed32());
                        break;
                    case 8:
                        valueOf = Boolean.valueOf(h1Var.readBool());
                        break;
                    case 9:
                        valueOf = Integer.valueOf(h1Var.readUInt32());
                        break;
                    case 10:
                        valueOf = Integer.valueOf(h1Var.readSFixed32());
                        break;
                    case 11:
                        valueOf = Long.valueOf(h1Var.readSFixed64());
                        break;
                    case 12:
                        valueOf = Integer.valueOf(h1Var.readSInt32());
                        break;
                    case 13:
                        valueOf = Long.valueOf(h1Var.readSInt64());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        valueOf = h1Var.readBytes();
                        break;
                    case 16:
                        valueOf = h1Var.readString();
                        break;
                    case 17:
                        if (!gVar.isRepeated()) {
                            Object field2 = tVar.getField(gVar.descriptor);
                            if (field2 instanceof GeneratedMessageLite) {
                                i1 schemaFor = d1.getInstance().schemaFor((d1) field2);
                                if (!((GeneratedMessageLite) field2).isMutable()) {
                                    Object newInstance = schemaFor.newInstance();
                                    schemaFor.mergeFrom(newInstance, field2);
                                    tVar.setField(gVar.descriptor, newInstance);
                                    field2 = newInstance;
                                }
                                h1Var.mergeGroupField(field2, schemaFor, oVar);
                                return ub2;
                            }
                        }
                        valueOf = h1Var.readGroup(gVar.getMessageDefaultInstance().getClass(), oVar);
                        break;
                    case 18:
                        if (!gVar.isRepeated()) {
                            Object field3 = tVar.getField(gVar.descriptor);
                            if (field3 instanceof GeneratedMessageLite) {
                                i1 schemaFor2 = d1.getInstance().schemaFor((d1) field3);
                                if (!((GeneratedMessageLite) field3).isMutable()) {
                                    Object newInstance2 = schemaFor2.newInstance();
                                    schemaFor2.mergeFrom(newInstance2, field3);
                                    tVar.setField(gVar.descriptor, newInstance2);
                                    field3 = newInstance2;
                                }
                                h1Var.mergeMessageField(field3, schemaFor2, oVar);
                                return ub2;
                            }
                        }
                        valueOf = h1Var.readMessage(gVar.getMessageDefaultInstance().getClass(), oVar);
                        break;
                    default:
                        valueOf = null;
                        break;
                }
            } else {
                int readInt32 = h1Var.readInt32();
                if (gVar.descriptor.getEnumType().findValueByNumber(readInt32) == null) {
                    return (UB) k1.storeUnknownEnum(obj, number, readInt32, ub2, o1Var);
                }
                valueOf = Integer.valueOf(readInt32);
            }
            if (gVar.isRepeated()) {
                tVar.addRepeatedField(gVar.descriptor, valueOf);
            } else {
                int i11 = a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[gVar.getLiteType().ordinal()];
                if ((i11 == 17 || i11 == 18) && (field = tVar.getField(gVar.descriptor)) != null) {
                    valueOf = y.mergeMessage(field, valueOf);
                }
                tVar.setField(gVar.descriptor, valueOf);
            }
        }
        return ub2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public void parseLengthPrefixedMessageSetItem(h1 h1Var, Object obj, o oVar, t tVar) throws IOException {
        GeneratedMessageLite.g gVar = (GeneratedMessageLite.g) obj;
        tVar.setField(gVar.descriptor, h1Var.readMessage(gVar.getMessageDefaultInstance().getClass(), oVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public void parseMessageSetItem(ByteString byteString, Object obj, o oVar, t tVar) throws IOException {
        GeneratedMessageLite.g gVar = (GeneratedMessageLite.g) obj;
        s0.a newBuilderForType = gVar.getMessageDefaultInstance().newBuilderForType();
        i newCodedInput = byteString.newCodedInput();
        newBuilderForType.mergeFrom(newCodedInput, oVar);
        tVar.setField(gVar.descriptor, newBuilderForType.buildPartial());
        newCodedInput.checkLastTagWas(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.p
    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.f fVar = (GeneratedMessageLite.f) entry.getKey();
        if (!fVar.isRepeated()) {
            switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fVar.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(fVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.writeFloat(fVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.writeInt64(fVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.writeUInt64(fVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.writeInt32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.writeFixed64(fVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.writeFixed32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.writeBool(fVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.writeUInt32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.writeSFixed32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.writeSFixed64(fVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.writeSInt32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.writeSInt64(fVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.writeInt32(fVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    writer.writeBytes(fVar.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.writeString(fVar.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.writeGroup(fVar.getNumber(), entry.getValue(), d1.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    return;
                case 18:
                    writer.writeMessage(fVar.getNumber(), entry.getValue(), d1.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
        switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fVar.getLiteType().ordinal()]) {
            case 1:
                k1.writeDoubleList(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 2:
                k1.writeFloatList(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 3:
                k1.writeInt64List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 4:
                k1.writeUInt64List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 5:
                k1.writeInt32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 6:
                k1.writeFixed64List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 7:
                k1.writeFixed32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 8:
                k1.writeBoolList(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 9:
                k1.writeUInt32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 10:
                k1.writeSFixed32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 11:
                k1.writeSFixed64List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 12:
                k1.writeSInt32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 13:
                k1.writeSInt64List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 14:
                k1.writeInt32List(fVar.getNumber(), (List) entry.getValue(), writer, fVar.isPacked());
                return;
            case 15:
                k1.writeBytesList(fVar.getNumber(), (List) entry.getValue(), writer);
                return;
            case 16:
                k1.writeStringList(fVar.getNumber(), (List) entry.getValue(), writer);
                return;
            case 17:
                List list = (List) entry.getValue();
                if (list == null || list.isEmpty()) {
                    return;
                }
                k1.writeGroupList(fVar.getNumber(), (List) entry.getValue(), writer, d1.getInstance().schemaFor((Class) list.get(0).getClass()));
                return;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                k1.writeMessageList(fVar.getNumber(), (List) entry.getValue(), writer, d1.getInstance().schemaFor((Class) list2.get(0).getClass()));
                return;
            default:
                return;
        }
    }

    @Override // com.google.protobuf.p
    void setExtensions(Object obj, t tVar) {
        ((GeneratedMessageLite.d) obj).extensions = tVar;
    }
}
