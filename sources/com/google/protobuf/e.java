package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.y;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
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
    /* loaded from: classes4.dex */
    public static final class b {
        public final o extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        b() {
            this.extensionRegistry = o.getEmptyRegistry();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(o oVar) {
            oVar.getClass();
            this.extensionRegistry = oVar;
        }
    }

    private e() {
    }

    private static void checkRecursionLimit(int i11) throws InvalidProtocolBufferException {
        if (i11 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeBoolList(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        f fVar = (f) jVar;
        int decodeVarint64 = decodeVarint64(bArr, i12, bVar);
        fVar.addBoolean(bVar.long1 != 0);
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, bVar);
            fVar.addBoolean(bVar.long1 != 0);
        }
        return decodeVarint64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeBytes(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i12 == 0) {
            bVar.object1 = ByteString.EMPTY;
            return decodeVarint32;
        }
        bVar.object1 = ByteString.copyFrom(bArr, decodeVarint32, i12);
        return decodeVarint32 + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeBytesList(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
        int i14 = bVar.int1;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i14 == 0) {
            jVar.add(ByteString.EMPTY);
        } else {
            jVar.add(ByteString.copyFrom(bArr, decodeVarint32, i14));
            decodeVarint32 += i14;
        }
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, bVar);
            int i15 = bVar.int1;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 > bArr.length - decodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i15 == 0) {
                jVar.add(ByteString.EMPTY);
            } else {
                jVar.add(ByteString.copyFrom(bArr, decodeVarint32, i15));
                decodeVarint32 += i15;
            }
        }
        return decodeVarint32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double decodeDouble(byte[] bArr, int i11) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeDoubleList(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        l lVar = (l) jVar;
        lVar.addDouble(decodeDouble(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            lVar.addDouble(decodeDouble(bArr, decodeVarint32));
            i14 = decodeVarint32 + 8;
        }
        return i14;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0122. Please report as an issue. */
    static int decodeExtension(int i11, byte[] bArr, int i12, int i13, GeneratedMessageLite.d dVar, GeneratedMessageLite.g gVar, o1 o1Var, b bVar) throws IOException {
        t tVar = dVar.extensions;
        int i14 = i11 >>> 3;
        if (gVar.descriptor.isRepeated() && gVar.descriptor.isPacked()) {
            switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[gVar.getLiteType().ordinal()]) {
                case 1:
                    l lVar = new l();
                    int decodePackedDoubleList = decodePackedDoubleList(bArr, i12, lVar, bVar);
                    tVar.setField(gVar.descriptor, lVar);
                    return decodePackedDoubleList;
                case 2:
                    u uVar = new u();
                    int decodePackedFloatList = decodePackedFloatList(bArr, i12, uVar, bVar);
                    tVar.setField(gVar.descriptor, uVar);
                    return decodePackedFloatList;
                case 3:
                case 4:
                    k0 k0Var = new k0();
                    int decodePackedVarint64List = decodePackedVarint64List(bArr, i12, k0Var, bVar);
                    tVar.setField(gVar.descriptor, k0Var);
                    return decodePackedVarint64List;
                case 5:
                case 6:
                    w wVar = new w();
                    int decodePackedVarint32List = decodePackedVarint32List(bArr, i12, wVar, bVar);
                    tVar.setField(gVar.descriptor, wVar);
                    return decodePackedVarint32List;
                case 7:
                case 8:
                    k0 k0Var2 = new k0();
                    int decodePackedFixed64List = decodePackedFixed64List(bArr, i12, k0Var2, bVar);
                    tVar.setField(gVar.descriptor, k0Var2);
                    return decodePackedFixed64List;
                case 9:
                case 10:
                    w wVar2 = new w();
                    int decodePackedFixed32List = decodePackedFixed32List(bArr, i12, wVar2, bVar);
                    tVar.setField(gVar.descriptor, wVar2);
                    return decodePackedFixed32List;
                case 11:
                    f fVar = new f();
                    int decodePackedBoolList = decodePackedBoolList(bArr, i12, fVar, bVar);
                    tVar.setField(gVar.descriptor, fVar);
                    return decodePackedBoolList;
                case 12:
                    w wVar3 = new w();
                    int decodePackedSInt32List = decodePackedSInt32List(bArr, i12, wVar3, bVar);
                    tVar.setField(gVar.descriptor, wVar3);
                    return decodePackedSInt32List;
                case 13:
                    k0 k0Var3 = new k0();
                    int decodePackedSInt64List = decodePackedSInt64List(bArr, i12, k0Var3, bVar);
                    tVar.setField(gVar.descriptor, k0Var3);
                    return decodePackedSInt64List;
                case 14:
                    w wVar4 = new w();
                    int decodePackedVarint32List2 = decodePackedVarint32List(bArr, i12, wVar4, bVar);
                    k1.filterUnknownEnumList(dVar, i14, wVar4, gVar.descriptor.getEnumType(), (Object) null, o1Var);
                    tVar.setField(gVar.descriptor, wVar4);
                    return decodePackedVarint32List2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + gVar.descriptor.getLiteType());
            }
        }
        Object obj = null;
        if (gVar.getLiteType() == WireFormat.FieldType.ENUM) {
            i12 = decodeVarint32(bArr, i12, bVar);
            if (gVar.descriptor.getEnumType().findValueByNumber(bVar.int1) == null) {
                k1.storeUnknownEnum(dVar, i14, bVar.int1, null, o1Var);
                return i12;
            }
            obj = Integer.valueOf(bVar.int1);
        } else {
            switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[gVar.getLiteType().ordinal()]) {
                case 1:
                    obj = Double.valueOf(decodeDouble(bArr, i12));
                    i12 += 8;
                    break;
                case 2:
                    obj = Float.valueOf(decodeFloat(bArr, i12));
                    i12 += 4;
                    break;
                case 3:
                case 4:
                    i12 = decodeVarint64(bArr, i12, bVar);
                    obj = Long.valueOf(bVar.long1);
                    break;
                case 5:
                case 6:
                    i12 = decodeVarint32(bArr, i12, bVar);
                    obj = Integer.valueOf(bVar.int1);
                    break;
                case 7:
                case 8:
                    obj = Long.valueOf(decodeFixed64(bArr, i12));
                    i12 += 8;
                    break;
                case 9:
                case 10:
                    obj = Integer.valueOf(decodeFixed32(bArr, i12));
                    i12 += 4;
                    break;
                case 11:
                    i12 = decodeVarint64(bArr, i12, bVar);
                    obj = Boolean.valueOf(bVar.long1 != 0);
                    break;
                case 12:
                    i12 = decodeVarint32(bArr, i12, bVar);
                    obj = Integer.valueOf(i.decodeZigZag32(bVar.int1));
                    break;
                case 13:
                    i12 = decodeVarint64(bArr, i12, bVar);
                    obj = Long.valueOf(i.decodeZigZag64(bVar.long1));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i12 = decodeBytes(bArr, i12, bVar);
                    obj = bVar.object1;
                    break;
                case 16:
                    i12 = decodeString(bArr, i12, bVar);
                    obj = bVar.object1;
                    break;
                case 17:
                    int i15 = (i14 << 3) | 4;
                    i1 schemaFor = d1.getInstance().schemaFor((Class) gVar.getMessageDefaultInstance().getClass());
                    if (gVar.isRepeated()) {
                        int decodeGroupField = decodeGroupField(schemaFor, bArr, i12, i13, i15, bVar);
                        tVar.addRepeatedField(gVar.descriptor, bVar.object1);
                        return decodeGroupField;
                    }
                    Object field = tVar.getField(gVar.descriptor);
                    if (field == null) {
                        field = schemaFor.newInstance();
                        tVar.setField(gVar.descriptor, field);
                    }
                    return mergeGroupField(field, schemaFor, bArr, i12, i13, i15, bVar);
                case 18:
                    i1 schemaFor2 = d1.getInstance().schemaFor((Class) gVar.getMessageDefaultInstance().getClass());
                    if (gVar.isRepeated()) {
                        int decodeMessageField = decodeMessageField(schemaFor2, bArr, i12, i13, bVar);
                        tVar.addRepeatedField(gVar.descriptor, bVar.object1);
                        return decodeMessageField;
                    }
                    Object field2 = tVar.getField(gVar.descriptor);
                    if (field2 == null) {
                        field2 = schemaFor2.newInstance();
                        tVar.setField(gVar.descriptor, field2);
                    }
                    return mergeMessageField(field2, schemaFor2, bArr, i12, i13, bVar);
            }
        }
        if (gVar.isRepeated()) {
            tVar.addRepeatedField(gVar.descriptor, obj);
        } else {
            tVar.setField(gVar.descriptor, obj);
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeExtensionOrUnknownField(int i11, byte[] bArr, int i12, int i13, Object obj, s0 s0Var, o1 o1Var, b bVar) throws IOException {
        GeneratedMessageLite.g findLiteExtensionByNumber = bVar.extensionRegistry.findLiteExtensionByNumber(s0Var, i11 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i11, bArr, i12, i13, v0.getMutableUnknownFields(obj), bVar);
        }
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) obj;
        dVar.ensureExtensionsAreMutable();
        return decodeExtension(i11, bArr, i12, i13, dVar, findLiteExtensionByNumber, o1Var, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeFixed32(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeFixed32List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        w wVar = (w) jVar;
        wVar.addInt(decodeFixed32(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            wVar.addInt(decodeFixed32(bArr, decodeVarint32));
            i14 = decodeVarint32 + 4;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long decodeFixed64(byte[] bArr, int i11) {
        return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeFixed64List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        k0 k0Var = (k0) jVar;
        k0Var.addLong(decodeFixed64(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            k0Var.addLong(decodeFixed64(bArr, decodeVarint32));
            i14 = decodeVarint32 + 8;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float decodeFloat(byte[] bArr, int i11) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeFloatList(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        u uVar = (u) jVar;
        uVar.addFloat(decodeFloat(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            uVar.addFloat(decodeFloat(bArr, decodeVarint32));
            i14 = decodeVarint32 + 4;
        }
        return i14;
    }

    static int decodeGroupField(i1 i1Var, byte[] bArr, int i11, int i12, int i13, b bVar) throws IOException {
        Object newInstance = i1Var.newInstance();
        int mergeGroupField = mergeGroupField(newInstance, i1Var, bArr, i11, i12, i13, bVar);
        i1Var.makeImmutable(newInstance);
        bVar.object1 = newInstance;
        return mergeGroupField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeGroupList(i1 i1Var, int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) throws IOException {
        int i14 = (i11 & (-8)) | 4;
        int decodeGroupField = decodeGroupField(i1Var, bArr, i12, i13, i14, bVar);
        jVar.add(bVar.object1);
        while (decodeGroupField < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(i1Var, bArr, decodeVarint32, i13, i14, bVar);
            jVar.add(bVar.object1);
        }
        return decodeGroupField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeMessageField(i1 i1Var, byte[] bArr, int i11, int i12, b bVar) throws IOException {
        Object newInstance = i1Var.newInstance();
        int mergeMessageField = mergeMessageField(newInstance, i1Var, bArr, i11, i12, bVar);
        i1Var.makeImmutable(newInstance);
        bVar.object1 = newInstance;
        return mergeMessageField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeMessageList(i1 i1Var, int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) throws IOException {
        int decodeMessageField = decodeMessageField(i1Var, bArr, i12, i13, bVar);
        jVar.add(bVar.object1);
        while (decodeMessageField < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(i1Var, bArr, decodeVarint32, i13, bVar);
            jVar.add(bVar.object1);
        }
        return decodeMessageField;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedBoolList(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        f fVar = (f) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, bVar);
            fVar.addBoolean(bVar.long1 != 0);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedDoubleList(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        l lVar = (l) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            lVar.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedFixed32List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        w wVar = (w) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            wVar.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedFixed64List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        k0 k0Var = (k0) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            k0Var.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedFloatList(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        u uVar = (u) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            uVar.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedSInt32List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        w wVar = (w) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, bVar);
            wVar.addInt(i.decodeZigZag32(bVar.int1));
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedSInt64List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        k0 k0Var = (k0) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, bVar);
            k0Var.addLong(i.decodeZigZag64(bVar.long1));
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedVarint32List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        w wVar = (w) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, bVar);
            wVar.addInt(bVar.int1);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodePackedVarint64List(byte[] bArr, int i11, y.j jVar, b bVar) throws IOException {
        k0 k0Var = (k0) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, bVar);
            k0Var.addLong(bVar.long1);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeSInt32List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        w wVar = (w) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
        wVar.addInt(i.decodeZigZag32(bVar.int1));
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, bVar);
            wVar.addInt(i.decodeZigZag32(bVar.int1));
        }
        return decodeVarint32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeSInt64List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        k0 k0Var = (k0) jVar;
        int decodeVarint64 = decodeVarint64(bArr, i12, bVar);
        k0Var.addLong(i.decodeZigZag64(bVar.long1));
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, bVar);
            k0Var.addLong(i.decodeZigZag64(bVar.long1));
        }
        return decodeVarint64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeString(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            bVar.object1 = "";
            return decodeVarint32;
        }
        bVar.object1 = new String(bArr, decodeVarint32, i12, y.UTF_8);
        return decodeVarint32 + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeStringList(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
        int i14 = bVar.int1;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            jVar.add("");
        } else {
            jVar.add(new String(bArr, decodeVarint32, i14, y.UTF_8));
            decodeVarint32 += i14;
        }
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, bVar);
            int i15 = bVar.int1;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 == 0) {
                jVar.add("");
            } else {
                jVar.add(new String(bArr, decodeVarint32, i15, y.UTF_8));
                decodeVarint32 += i15;
            }
        }
        return decodeVarint32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeStringListRequireUtf8(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
        int i14 = bVar.int1;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            jVar.add("");
        } else {
            int i15 = decodeVarint32 + i14;
            if (!Utf8.isValidUtf8(bArr, decodeVarint32, i15)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            jVar.add(new String(bArr, decodeVarint32, i14, y.UTF_8));
            decodeVarint32 = i15;
        }
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, bVar);
            int i16 = bVar.int1;
            if (i16 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i16 == 0) {
                jVar.add("");
            } else {
                int i17 = decodeVarint32 + i16;
                if (!Utf8.isValidUtf8(bArr, decodeVarint32, i17)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                jVar.add(new String(bArr, decodeVarint32, i16, y.UTF_8));
                decodeVarint32 = i17;
            }
        }
        return decodeVarint32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeStringRequireUtf8(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, bVar);
        int i12 = bVar.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            bVar.object1 = "";
            return decodeVarint32;
        }
        bVar.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i12);
        return decodeVarint32 + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeUnknownField(int i11, byte[] bArr, int i12, int i13, p1 p1Var, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i11);
        if (tagWireType == 0) {
            int decodeVarint64 = decodeVarint64(bArr, i12, bVar);
            p1Var.storeField(i11, Long.valueOf(bVar.long1));
            return decodeVarint64;
        }
        if (tagWireType == 1) {
            p1Var.storeField(i11, Long.valueOf(decodeFixed64(bArr, i12)));
            return i12 + 8;
        }
        if (tagWireType == 2) {
            int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
            int i14 = bVar.int1;
            if (i14 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i14 > bArr.length - decodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i14 == 0) {
                p1Var.storeField(i11, ByteString.EMPTY);
            } else {
                p1Var.storeField(i11, ByteString.copyFrom(bArr, decodeVarint32, i14));
            }
            return decodeVarint32 + i14;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            p1Var.storeField(i11, Integer.valueOf(decodeFixed32(bArr, i12)));
            return i12 + 4;
        }
        p1 newInstance = p1.newInstance();
        int i15 = (i11 & (-8)) | 4;
        int i16 = bVar.recursionDepth + 1;
        bVar.recursionDepth = i16;
        checkRecursionLimit(i16);
        int i17 = 0;
        while (true) {
            if (i12 >= i13) {
                break;
            }
            int decodeVarint322 = decodeVarint32(bArr, i12, bVar);
            int i18 = bVar.int1;
            if (i18 == i15) {
                i17 = i18;
                i12 = decodeVarint322;
                break;
            }
            i17 = i18;
            i12 = decodeUnknownField(i18, bArr, decodeVarint322, i13, newInstance, bVar);
        }
        bVar.recursionDepth--;
        if (i12 > i13 || i17 != i15) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        p1Var.storeField(i11, newInstance);
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeVarint32(int i11, byte[] bArr, int i12, b bVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            bVar.int1 = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            bVar.int1 = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            bVar.int1 = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << 21);
        int i20 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            bVar.int1 = i19 | (b14 << 28);
            return i20;
        }
        int i21 = i19 | ((b14 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i22 = i20 + 1;
            if (bArr[i20] >= 0) {
                bVar.int1 = i21;
                return i22;
            }
            i20 = i22;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeVarint32(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return decodeVarint32(b11, bArr, i12, bVar);
        }
        bVar.int1 = b11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeVarint32List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        w wVar = (w) jVar;
        int decodeVarint32 = decodeVarint32(bArr, i12, bVar);
        wVar.addInt(bVar.int1);
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, bVar);
            wVar.addInt(bVar.int1);
        }
        return decodeVarint32;
    }

    static int decodeVarint64(long j11, byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        long j12 = (j11 & 127) | ((b11 & Byte.MAX_VALUE) << 7);
        int i13 = 7;
        while (b11 < 0) {
            int i14 = i12 + 1;
            byte b12 = bArr[i12];
            i13 += 7;
            j12 |= (b12 & Byte.MAX_VALUE) << i13;
            i12 = i14;
            b11 = b12;
        }
        bVar.long1 = j12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeVarint64(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        if (j11 < 0) {
            return decodeVarint64(j11, bArr, i12, bVar);
        }
        bVar.long1 = j11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeVarint64List(int i11, byte[] bArr, int i12, int i13, y.j jVar, b bVar) {
        k0 k0Var = (k0) jVar;
        int decodeVarint64 = decodeVarint64(bArr, i12, bVar);
        k0Var.addLong(bVar.long1);
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, bVar);
            if (i11 != bVar.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, bVar);
            k0Var.addLong(bVar.long1);
        }
        return decodeVarint64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mergeGroupField(Object obj, i1 i1Var, byte[] bArr, int i11, int i12, int i13, b bVar) throws IOException {
        v0 v0Var = (v0) i1Var;
        int i14 = bVar.recursionDepth + 1;
        bVar.recursionDepth = i14;
        checkRecursionLimit(i14);
        int parseMessage = v0Var.parseMessage(obj, bArr, i11, i12, i13, bVar);
        bVar.recursionDepth--;
        bVar.object1 = obj;
        return parseMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mergeMessageField(Object obj, i1 i1Var, byte[] bArr, int i11, int i12, b bVar) throws IOException {
        int i13 = i11 + 1;
        int i14 = bArr[i11];
        if (i14 < 0) {
            i13 = decodeVarint32(i14, bArr, i13, bVar);
            i14 = bVar.int1;
        }
        int i15 = i13;
        if (i14 < 0 || i14 > i12 - i15) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i16 = bVar.recursionDepth + 1;
        bVar.recursionDepth = i16;
        checkRecursionLimit(i16);
        int i17 = i14 + i15;
        i1Var.mergeFrom(obj, bArr, i15, i17, bVar);
        bVar.recursionDepth--;
        bVar.object1 = obj;
        return i17;
    }

    public static void setRecursionLimit(int i11) {
        recursionLimit = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int skipField(int i11, byte[] bArr, int i12, int i13, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i11);
        if (tagWireType == 0) {
            return decodeVarint64(bArr, i12, bVar);
        }
        if (tagWireType == 1) {
            return i12 + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(bArr, i12, bVar) + bVar.int1;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                return i12 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i14 = (i11 & (-8)) | 4;
        int i15 = 0;
        while (i12 < i13) {
            i12 = decodeVarint32(bArr, i12, bVar);
            i15 = bVar.int1;
            if (i15 == i14) {
                break;
            }
            i12 = skipField(i15, bArr, i12, i13, bVar);
        }
        if (i12 > i13 || i15 != i14) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i12;
    }
}
