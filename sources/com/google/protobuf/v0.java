package com.google.protobuf;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.google.protobuf.e;
import com.google.protobuf.m0;
import com.google.protobuf.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class v0 implements i1 {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final s0 defaultInstance;
    private final p extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final j0 listFieldSchema;
    private final boolean lite;
    private final n0 mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final x0 newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final o1 unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = s1.getUnsafe();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private v0(int[] iArr, Object[] objArr, int i11, int i12, s0 s0Var, ProtoSyntax protoSyntax, boolean z10, int[] iArr2, int i13, int i14, x0 x0Var, j0 j0Var, o1 o1Var, p pVar, n0 n0Var) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i11;
        this.maxFieldNumber = i12;
        this.lite = s0Var instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = pVar != null && pVar.hasExtensions(s0Var);
        this.useCachedSizeField = z10;
        this.intArray = iArr2;
        this.checkInitializedCount = i13;
        this.repeatedFieldOffsetStart = i14;
        this.newInstanceSchema = x0Var;
        this.listFieldSchema = j0Var;
        this.unknownFieldSchema = o1Var;
        this.extensionSchema = pVar;
        this.defaultInstance = s0Var;
        this.mapFieldSchema = n0Var;
    }

    private boolean arePresentForEquals(Object obj, Object obj2, int i11) {
        return isFieldPresent(obj, i11) == isFieldPresent(obj2, i11);
    }

    private static <T> boolean booleanAt(T t11, long j11) {
        return s1.getBoolean(t11, j11);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int decodeMapEntry(byte[] bArr, int i11, int i12, m0.b bVar, Map<K, V> map, e.b bVar2) throws IOException {
        int i13;
        int decodeVarint32 = e.decodeVarint32(bArr, i11, bVar2);
        int i14 = bVar2.int1;
        if (i14 < 0 || i14 > i12 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i15 = decodeVarint32 + i14;
        Object obj = bVar.defaultKey;
        Object obj2 = bVar.defaultValue;
        while (decodeVarint32 < i15) {
            int i16 = decodeVarint32 + 1;
            byte b11 = bArr[decodeVarint32];
            if (b11 < 0) {
                i13 = e.decodeVarint32(b11, bArr, i16, bVar2);
                b11 = bVar2.int1;
            } else {
                i13 = i16;
            }
            int i17 = b11 >>> 3;
            int i18 = b11 & 7;
            if (i17 != 1) {
                if (i17 == 2 && i18 == bVar.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i13, i12, bVar.valueType, bVar.defaultValue.getClass(), bVar2);
                    obj2 = bVar2.object1;
                }
                decodeVarint32 = e.skipField(b11, bArr, i13, i12, bVar2);
            } else if (i18 == bVar.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i13, i12, bVar.keyType, null, bVar2);
                obj = bVar2.object1;
            } else {
                decodeVarint32 = e.skipField(b11, bArr, i13, i12, bVar2);
            }
        }
        if (decodeVarint32 != i15) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private int decodeMapEntryValue(byte[] bArr, int i11, int i12, WireFormat.FieldType fieldType, Class<?> cls, e.b bVar) throws IOException {
        switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = e.decodeVarint64(bArr, i11, bVar);
                bVar.object1 = Boolean.valueOf(bVar.long1 != 0);
                return decodeVarint64;
            case 2:
                return e.decodeBytes(bArr, i11, bVar);
            case 3:
                bVar.object1 = Double.valueOf(e.decodeDouble(bArr, i11));
                return i11 + 8;
            case 4:
            case 5:
                bVar.object1 = Integer.valueOf(e.decodeFixed32(bArr, i11));
                return i11 + 4;
            case 6:
            case 7:
                bVar.object1 = Long.valueOf(e.decodeFixed64(bArr, i11));
                return i11 + 8;
            case 8:
                bVar.object1 = Float.valueOf(e.decodeFloat(bArr, i11));
                return i11 + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = e.decodeVarint32(bArr, i11, bVar);
                bVar.object1 = Integer.valueOf(bVar.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = e.decodeVarint64(bArr, i11, bVar);
                bVar.object1 = Long.valueOf(bVar.long1);
                return decodeVarint642;
            case 14:
                return e.decodeMessageField(d1.getInstance().schemaFor((Class) cls), bArr, i11, i12, bVar);
            case 15:
                int decodeVarint322 = e.decodeVarint32(bArr, i11, bVar);
                bVar.object1 = Integer.valueOf(i.decodeZigZag32(bVar.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = e.decodeVarint64(bArr, i11, bVar);
                bVar.object1 = Long.valueOf(i.decodeZigZag64(bVar.long1));
                return decodeVarint643;
            case 17:
                return e.decodeStringRequireUtf8(bArr, i11, bVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t11, long j11) {
        return s1.getDouble(t11, j11);
    }

    private boolean equals(Object obj, Object obj2, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(obj, obj2, i11) && Double.doubleToLongBits(s1.getDouble(obj, offset)) == Double.doubleToLongBits(s1.getDouble(obj2, offset));
            case 1:
                return arePresentForEquals(obj, obj2, i11) && Float.floatToIntBits(s1.getFloat(obj, offset)) == Float.floatToIntBits(s1.getFloat(obj2, offset));
            case 2:
                return arePresentForEquals(obj, obj2, i11) && s1.getLong(obj, offset) == s1.getLong(obj2, offset);
            case 3:
                return arePresentForEquals(obj, obj2, i11) && s1.getLong(obj, offset) == s1.getLong(obj2, offset);
            case 4:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 5:
                return arePresentForEquals(obj, obj2, i11) && s1.getLong(obj, offset) == s1.getLong(obj2, offset);
            case 6:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 7:
                return arePresentForEquals(obj, obj2, i11) && s1.getBoolean(obj, offset) == s1.getBoolean(obj2, offset);
            case 8:
                return arePresentForEquals(obj, obj2, i11) && k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 9:
                return arePresentForEquals(obj, obj2, i11) && k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 10:
                return arePresentForEquals(obj, obj2, i11) && k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 11:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 12:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 13:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 14:
                return arePresentForEquals(obj, obj2, i11) && s1.getLong(obj, offset) == s1.getLong(obj2, offset);
            case 15:
                return arePresentForEquals(obj, obj2, i11) && s1.getInt(obj, offset) == s1.getInt(obj2, offset);
            case 16:
                return arePresentForEquals(obj, obj2, i11) && s1.getLong(obj, offset) == s1.getLong(obj2, offset);
            case 17:
                return arePresentForEquals(obj, obj2, i11) && k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                return k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 50:
                return k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            case 51:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(obj, obj2, i11) && k1.safeEquals(s1.getObject(obj, offset), s1.getObject(obj2, offset));
            default:
                return true;
        }
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i11, UB ub2, o1 o1Var, Object obj2) {
        y.e enumFieldVerifier;
        int numberAt = numberAt(i11);
        Object object = s1.getObject(obj, offset(typeAndOffsetAt(i11)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i11)) == null) ? ub2 : (UB) filterUnknownEnumMap(i11, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub2, o1Var, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i11, int i12, Map<K, V> map, y.e eVar, UB ub2, o1 o1Var, Object obj) {
        m0.b forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = (UB) o1Var.getBuilderFromMessage(obj);
                }
                ByteString.f newCodedBuilder = ByteString.newCodedBuilder(m0.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    m0.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    o1Var.addLengthDelimited(ub2, i12, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T t11, long j11) {
        return s1.getFloat(t11, j11);
    }

    private y.e getEnumFieldVerifier(int i11) {
        return (y.e) this.objects[((i11 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i11) {
        return this.objects[(i11 / 3) * 2];
    }

    private i1 getMessageFieldSchema(int i11) {
        int i12 = (i11 / 3) * 2;
        i1 i1Var = (i1) this.objects[i12];
        if (i1Var != null) {
            return i1Var;
        }
        i1 schemaFor = d1.getInstance().schemaFor((Class) this.objects[i12 + 1]);
        this.objects[i12] = schemaFor;
        return schemaFor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p1 getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        p1 p1Var = generatedMessageLite.unknownFields;
        if (p1Var != p1.getDefaultInstance()) {
            return p1Var;
        }
        p1 newInstance = p1.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(o1 o1Var, Object obj) {
        return o1Var.getSerializedSize(o1Var.getFromMessage(obj));
    }

    private static <T> int intAt(T t11, long j11) {
        return s1.getInt(t11, j11);
    }

    private static boolean isEnforceUtf8(int i11) {
        return (i11 & 536870912) != 0;
    }

    private boolean isFieldPresent(Object obj, int i11) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
        long j11 = 1048575 & presenceMaskAndOffsetAt;
        if (j11 != 1048575) {
            return (s1.getInt(obj, j11) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(s1.getDouble(obj, offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(s1.getFloat(obj, offset)) != 0;
            case 2:
                return s1.getLong(obj, offset) != 0;
            case 3:
                return s1.getLong(obj, offset) != 0;
            case 4:
                return s1.getInt(obj, offset) != 0;
            case 5:
                return s1.getLong(obj, offset) != 0;
            case 6:
                return s1.getInt(obj, offset) != 0;
            case 7:
                return s1.getBoolean(obj, offset);
            case 8:
                Object object = s1.getObject(obj, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return s1.getObject(obj, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(s1.getObject(obj, offset));
            case 11:
                return s1.getInt(obj, offset) != 0;
            case 12:
                return s1.getInt(obj, offset) != 0;
            case 13:
                return s1.getInt(obj, offset) != 0;
            case 14:
                return s1.getLong(obj, offset) != 0;
            case 15:
                return s1.getInt(obj, offset) != 0;
            case 16:
                return s1.getLong(obj, offset) != 0;
            case 17:
                return s1.getObject(obj, offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean isFieldPresent(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? isFieldPresent(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean isInitialized(Object obj, int i11, i1 i1Var) {
        return i1Var.isInitialized(s1.getObject(obj, offset(i11)));
    }

    private static boolean isLegacyEnumIsClosed(int i11) {
        return (i11 & Integer.MIN_VALUE) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i11, int i12) {
        List list = (List) s1.getObject(obj, offset(i11));
        if (list.isEmpty()) {
            return true;
        }
        i1 messageFieldSchema = getMessageFieldSchema(i12);
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (!messageFieldSchema.isInitialized(list.get(i13))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(Object obj, int i11, int i12) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(s1.getObject(obj, offset(i11)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i12)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        i1 i1Var = null;
        for (Object obj2 : forMapData.values()) {
            if (i1Var == null) {
                i1Var = d1.getInstance().schemaFor((Class) obj2.getClass());
            }
            if (!i1Var.isInitialized(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(Object obj, Object obj2, int i11) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11) & 1048575;
        return s1.getInt(obj, presenceMaskAndOffsetAt) == s1.getInt(obj2, presenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(Object obj, int i11, int i12) {
        return s1.getInt(obj, (long) (presenceMaskAndOffsetAt(i12) & 1048575)) == i11;
    }

    private static boolean isRequired(int i11) {
        return (i11 & 268435456) != 0;
    }

    private static <T> long longAt(T t11, long j11) {
        return s1.getLong(t11, j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x0093, code lost:
    
        r0 = r18.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0098, code lost:
    
        if (r0 >= r18.repeatedFieldOffsetStart) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x009a, code lost:
    
        r4 = filterMapUnknownEnumValues(r21, r18.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x00b0, code lost:
    
        r11 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x00b1, code lost:
    
        if (r4 == null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x00b3, code lost:
    
        r7.setBuilderToMessage(r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00b6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00c2. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x064b A[Catch: all -> 0x0671, TRY_LEAVE, TryCatch #0 {all -> 0x0671, blocks: (B:35:0x0645, B:37:0x064b, B:50:0x0675, B:51:0x067a), top: B:34:0x0645 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x06b1 A[LOOP:4: B:66:0x06ad->B:68:0x06b1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x06c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.t.c> void mergeFromHelper(com.google.protobuf.o1 r19, com.google.protobuf.p r20, java.lang.Object r21, com.google.protobuf.h1 r22, com.google.protobuf.o r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.mergeFromHelper(com.google.protobuf.o1, com.google.protobuf.p, java.lang.Object, com.google.protobuf.h1, com.google.protobuf.o):void");
    }

    private final <K, V> void mergeMap(Object obj, int i11, Object obj2, o oVar, h1 h1Var) throws IOException {
        long offset = offset(typeAndOffsetAt(i11));
        Object object = s1.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            s1.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            s1.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        h1Var.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), oVar);
    }

    private void mergeMessage(Object obj, Object obj2, int i11) {
        if (isFieldPresent(obj2, i11)) {
            long offset = offset(typeAndOffsetAt(i11));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i11) + " is present but null: " + obj2);
            }
            i1 messageFieldSchema = getMessageFieldSchema(i11);
            if (!isFieldPresent(obj, i11)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(obj, offset, newInstance);
                } else {
                    unsafe.putObject(obj, offset, object);
                }
                setFieldPresent(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(obj, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeOneofMessage(Object obj, Object obj2, int i11) {
        int numberAt = numberAt(i11);
        if (isOneofPresent(obj2, numberAt, i11)) {
            long offset = offset(typeAndOffsetAt(i11));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(obj2, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i11) + " is present but null: " + obj2);
            }
            i1 messageFieldSchema = getMessageFieldSchema(i11);
            if (!isOneofPresent(obj, numberAt, i11)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(obj, offset, newInstance);
                } else {
                    unsafe.putObject(obj, offset, object);
                }
                setOneofPresent(obj, numberAt, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(obj, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(Object obj, Object obj2, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i11);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(obj2, i11)) {
                    s1.putDouble(obj, offset, s1.getDouble(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(obj2, i11)) {
                    s1.putFloat(obj, offset, s1.getFloat(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(obj2, i11)) {
                    s1.putLong(obj, offset, s1.getLong(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(obj2, i11)) {
                    s1.putLong(obj, offset, s1.getLong(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(obj2, i11)) {
                    s1.putLong(obj, offset, s1.getLong(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(obj2, i11)) {
                    s1.putBoolean(obj, offset, s1.getBoolean(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(obj2, i11)) {
                    s1.putObject(obj, offset, s1.getObject(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 9:
                mergeMessage(obj, obj2, i11);
                return;
            case 10:
                if (isFieldPresent(obj2, i11)) {
                    s1.putObject(obj, offset, s1.getObject(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(obj2, i11)) {
                    s1.putLong(obj, offset, s1.getLong(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(obj2, i11)) {
                    s1.putInt(obj, offset, s1.getInt(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(obj2, i11)) {
                    s1.putLong(obj, offset, s1.getLong(obj2, offset));
                    setFieldPresent(obj, i11);
                    return;
                }
                return;
            case 17:
                mergeMessage(obj, obj2, i11);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                this.listFieldSchema.mergeListsAt(obj, obj2, offset);
                return;
            case 50:
                k1.mergeMap(this.mapFieldSchema, obj, obj2, offset);
                return;
            case 51:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
                if (isOneofPresent(obj2, numberAt, i11)) {
                    s1.putObject(obj, offset, s1.getObject(obj2, offset));
                    setOneofPresent(obj, numberAt, i11);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(obj, obj2, i11);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case 67:
                if (isOneofPresent(obj2, numberAt, i11)) {
                    s1.putObject(obj, offset, s1.getObject(obj2, offset));
                    setOneofPresent(obj, numberAt, i11);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(obj, obj2, i11);
                return;
            default:
                return;
        }
    }

    private Object mutableMessageFieldForMerge(Object obj, int i11) {
        i1 messageFieldSchema = getMessageFieldSchema(i11);
        long offset = offset(typeAndOffsetAt(i11));
        if (!isFieldPresent(obj, i11)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private Object mutableOneofMessageFieldForMerge(Object obj, int i11, int i12) {
        i1 messageFieldSchema = getMessageFieldSchema(i12);
        if (!isOneofPresent(obj, i11, i12)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(obj, offset(typeAndOffsetAt(i12)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> v0 newSchema(Class<T> cls, q0 q0Var, x0 x0Var, j0 j0Var, o1 o1Var, p pVar, n0 n0Var) {
        return q0Var instanceof g1 ? newSchemaForRawMessageInfo((g1) q0Var, x0Var, j0Var, o1Var, pVar, n0Var) : newSchemaForMessageInfo((m1) q0Var, x0Var, j0Var, o1Var, pVar, n0Var);
    }

    static <T> v0 newSchemaForMessageInfo(m1 m1Var, x0 x0Var, j0 j0Var, o1 o1Var, p pVar, n0 n0Var) {
        int fieldNumber;
        int fieldNumber2;
        int i11;
        s[] fields = m1Var.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i12 = 0;
        int i13 = 0;
        for (s sVar : fields) {
            if (sVar.getType() == FieldType.MAP) {
                i12++;
            } else if (sVar.getType().id() >= 18 && sVar.getType().id() <= 49) {
                i13++;
            }
        }
        int[] iArr2 = i12 > 0 ? new int[i12] : null;
        int[] iArr3 = i13 > 0 ? new int[i13] : null;
        int[] checkInitialized = m1Var.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i14 < fields.length) {
            s sVar2 = fields[i14];
            int fieldNumber3 = sVar2.getFieldNumber();
            storeFieldData(sVar2, iArr, i15, objArr);
            if (i16 < checkInitialized.length && checkInitialized[i16] == fieldNumber3) {
                checkInitialized[i16] = i15;
                i16++;
            }
            if (sVar2.getType() == FieldType.MAP) {
                iArr2[i17] = i15;
                i17++;
            } else if (sVar2.getType().id() >= 18 && sVar2.getType().id() <= 49) {
                i11 = i15;
                iArr3[i18] = (int) s1.objectFieldOffset(sVar2.getField());
                i18++;
                i14++;
                i15 = i11 + 3;
            }
            i11 = i15;
            i14++;
            i15 = i11 + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new v0(iArr, objArr, fieldNumber, fieldNumber2, m1Var.getDefaultInstance(), m1Var.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, x0Var, j0Var, o1Var, pVar, n0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.protobuf.v0 newSchemaForRawMessageInfo(com.google.protobuf.g1 r31, com.google.protobuf.x0 r32, com.google.protobuf.j0 r33, com.google.protobuf.o1 r34, com.google.protobuf.p r35, com.google.protobuf.n0 r36) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.newSchemaForRawMessageInfo(com.google.protobuf.g1, com.google.protobuf.x0, com.google.protobuf.j0, com.google.protobuf.o1, com.google.protobuf.p, com.google.protobuf.n0):com.google.protobuf.v0");
    }

    private int numberAt(int i11) {
        return this.buffer[i11];
    }

    private static long offset(int i11) {
        return i11 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t11, long j11) {
        return ((Boolean) s1.getObject(t11, j11)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t11, long j11) {
        return ((Double) s1.getObject(t11, j11)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t11, long j11) {
        return ((Float) s1.getObject(t11, j11)).floatValue();
    }

    private static <T> int oneofIntAt(T t11, long j11) {
        return ((Integer) s1.getObject(t11, j11)).intValue();
    }

    private static <T> long oneofLongAt(T t11, long j11) {
        return ((Long) s1.getObject(t11, j11)).longValue();
    }

    private <K, V> int parseMapField(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, e.b bVar) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i13);
        Object object = unsafe.getObject(obj, j11);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(obj, j11, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i11, i12, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), bVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private int parseOneofField(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, e.b bVar) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j12 = this.buffer[i18 + 2] & 1048575;
        switch (i17) {
            case 51:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Double.valueOf(e.decodeDouble(bArr, i11)));
                    int i19 = i11 + 8;
                    unsafe.putInt(obj, j12, i14);
                    return i19;
                }
                return i11;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Float.valueOf(e.decodeFloat(bArr, i11)));
                    int i20 = i11 + 4;
                    unsafe.putInt(obj, j12, i14);
                    return i20;
                }
                return i11;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (i15 == 0) {
                    int decodeVarint64 = e.decodeVarint64(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, Long.valueOf(bVar.long1));
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint64;
                }
                return i11;
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case 62:
                if (i15 == 0) {
                    int decodeVarint32 = e.decodeVarint32(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(bVar.int1));
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint32;
                }
                return i11;
            case AD_VISIBILITY_VALUE:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Long.valueOf(e.decodeFixed64(bArr, i11)));
                    int i21 = i11 + 8;
                    unsafe.putInt(obj, j12, i14);
                    return i21;
                }
                return i11;
            case 57:
            case 64:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Integer.valueOf(e.decodeFixed32(bArr, i11)));
                    int i22 = i11 + 4;
                    unsafe.putInt(obj, j12, i14);
                    return i22;
                }
                return i11;
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                if (i15 == 0) {
                    int decodeVarint642 = e.decodeVarint64(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, Boolean.valueOf(bVar.long1 != 0));
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint642;
                }
                return i11;
            case 59:
                if (i15 == 2) {
                    int decodeVarint322 = e.decodeVarint32(bArr, i11, bVar);
                    int i23 = bVar.int1;
                    if (i23 == 0) {
                        unsafe.putObject(obj, j11, "");
                    } else {
                        if ((i16 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i23)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(obj, j11, new String(bArr, decodeVarint322, i23, y.UTF_8));
                        decodeVarint322 += i23;
                    }
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint322;
                }
                return i11;
            case 60:
                if (i15 == 2) {
                    Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(obj, i14, i18);
                    int mergeMessageField = e.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i18), bArr, i11, i12, bVar);
                    storeOneofMessageField(obj, i14, i18, mutableOneofMessageFieldForMerge);
                    return mergeMessageField;
                }
                return i11;
            case 61:
                if (i15 == 2) {
                    int decodeBytes = e.decodeBytes(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, bVar.object1);
                    unsafe.putInt(obj, j12, i14);
                    return decodeBytes;
                }
                return i11;
            case 63:
                if (i15 == 0) {
                    int decodeVarint323 = e.decodeVarint32(bArr, i11, bVar);
                    int i24 = bVar.int1;
                    y.e enumFieldVerifier = getEnumFieldVerifier(i18);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i24)) {
                        unsafe.putObject(obj, j11, Integer.valueOf(i24));
                        unsafe.putInt(obj, j12, i14);
                    } else {
                        getMutableUnknownFields(obj).storeField(i13, Long.valueOf(i24));
                    }
                    return decodeVarint323;
                }
                return i11;
            case 66:
                if (i15 == 0) {
                    int decodeVarint324 = e.decodeVarint32(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(i.decodeZigZag32(bVar.int1)));
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint324;
                }
                return i11;
            case 67:
                if (i15 == 0) {
                    int decodeVarint643 = e.decodeVarint64(bArr, i11, bVar);
                    unsafe.putObject(obj, j11, Long.valueOf(i.decodeZigZag64(bVar.long1)));
                    unsafe.putInt(obj, j12, i14);
                    return decodeVarint643;
                }
                return i11;
            case 68:
                if (i15 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(obj, i14, i18);
                    int mergeGroupField = e.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i18), bArr, i11, i12, (i13 & (-8)) | 4, bVar);
                    storeOneofMessageField(obj, i14, i18, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                return i11;
            default:
                return i11;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002f. Please report as an issue. */
    private int parseRepeatedField(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, e.b bVar) throws IOException {
        int decodeVarint32List;
        Unsafe unsafe = UNSAFE;
        y.j jVar = (y.j) unsafe.getObject(obj, j12);
        if (!jVar.isModifiable()) {
            int size = jVar.size();
            jVar = jVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j12, jVar);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    return e.decodePackedDoubleList(bArr, i11, jVar, bVar);
                }
                if (i15 == 1) {
                    return e.decodeDoubleList(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 19:
            case 36:
                if (i15 == 2) {
                    return e.decodePackedFloatList(bArr, i11, jVar, bVar);
                }
                if (i15 == 5) {
                    return e.decodeFloatList(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    return e.decodePackedVarint64List(bArr, i11, jVar, bVar);
                }
                if (i15 == 0) {
                    return e.decodeVarint64List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 22:
            case NOTIFICATION_REDIRECT_VALUE:
            case 39:
            case 43:
                if (i15 == 2) {
                    return e.decodePackedVarint32List(bArr, i11, jVar, bVar);
                }
                if (i15 == 0) {
                    return e.decodeVarint32List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    return e.decodePackedFixed64List(bArr, i11, jVar, bVar);
                }
                if (i15 == 1) {
                    return e.decodeFixed64List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 24:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 41:
            case 45:
                if (i15 == 2) {
                    return e.decodePackedFixed32List(bArr, i11, jVar, bVar);
                }
                if (i15 == 5) {
                    return e.decodeFixed32List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 25:
            case 42:
                if (i15 == 2) {
                    return e.decodePackedBoolList(bArr, i11, jVar, bVar);
                }
                if (i15 == 0) {
                    return e.decodeBoolList(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 26:
                if (i15 == 2) {
                    return (j11 & 536870912) == 0 ? e.decodeStringList(i13, bArr, i11, i12, jVar, bVar) : e.decodeStringListRequireUtf8(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 27:
                if (i15 == 2) {
                    return e.decodeMessageList(getMessageFieldSchema(i16), i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 28:
                if (i15 == 2) {
                    return e.decodeBytesList(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 30:
            case 44:
                if (i15 != 2) {
                    if (i15 == 0) {
                        decodeVarint32List = e.decodeVarint32List(i13, bArr, i11, i12, jVar, bVar);
                    }
                    return i11;
                }
                decodeVarint32List = e.decodePackedVarint32List(bArr, i11, jVar, bVar);
                k1.filterUnknownEnumList(obj, i14, jVar, getEnumFieldVerifier(i16), (Object) null, this.unknownFieldSchema);
                return decodeVarint32List;
            case 33:
            case 47:
                if (i15 == 2) {
                    return e.decodePackedSInt32List(bArr, i11, jVar, bVar);
                }
                if (i15 == 0) {
                    return e.decodeSInt32List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case 34:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                if (i15 == 2) {
                    return e.decodePackedSInt64List(bArr, i11, jVar, bVar);
                }
                if (i15 == 0) {
                    return e.decodeSInt64List(i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                if (i15 == 3) {
                    return e.decodeGroupList(getMessageFieldSchema(i16), i13, bArr, i11, i12, jVar, bVar);
                }
                return i11;
            default:
                return i11;
        }
    }

    private int positionForFieldNumber(int i11) {
        if (i11 < this.minFieldNumber || i11 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i11, 0);
    }

    private int positionForFieldNumber(int i11, int i12) {
        if (i11 < this.minFieldNumber || i11 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i11, i12);
    }

    private int presenceMaskAndOffsetAt(int i11) {
        return this.buffer[i11 + 2];
    }

    private <E> void readGroupList(Object obj, long j11, h1 h1Var, i1 i1Var, o oVar) throws IOException {
        h1Var.readGroupList(this.listFieldSchema.mutableListAt(obj, j11), i1Var, oVar);
    }

    private <E> void readMessageList(Object obj, int i11, h1 h1Var, i1 i1Var, o oVar) throws IOException {
        h1Var.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i11)), i1Var, oVar);
    }

    private void readString(Object obj, int i11, h1 h1Var) throws IOException {
        if (isEnforceUtf8(i11)) {
            s1.putObject(obj, offset(i11), h1Var.readStringRequireUtf8());
        } else if (this.lite) {
            s1.putObject(obj, offset(i11), h1Var.readString());
        } else {
            s1.putObject(obj, offset(i11), h1Var.readBytes());
        }
    }

    private void readStringList(Object obj, int i11, h1 h1Var) throws IOException {
        if (isEnforceUtf8(i11)) {
            h1Var.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i11)));
        } else {
            h1Var.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i11)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(Object obj, int i11) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
        long j11 = 1048575 & presenceMaskAndOffsetAt;
        if (j11 == 1048575) {
            return;
        }
        s1.putInt(obj, j11, (1 << (presenceMaskAndOffsetAt >>> 20)) | s1.getInt(obj, j11));
    }

    private void setOneofPresent(Object obj, int i11, int i12) {
        s1.putInt(obj, presenceMaskAndOffsetAt(i12) & 1048575, i11);
    }

    private int slowPositionForFieldNumber(int i11, int i12) {
        int length = (this.buffer.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int numberAt = numberAt(i14);
            if (i11 == numberAt) {
                return i14;
            }
            if (i11 < numberAt) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.s r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.a1 r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.protobuf.s1.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = com.google.protobuf.s1.objectFieldOffset(r0)
        L22:
            int r0 = (int) r4
            r4 = r1
            goto L6c
        L25:
            com.google.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.protobuf.s1.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r4 = com.google.protobuf.s1.objectFieldOffset(r0)
            int r0 = (int) r4
        L51:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L6c
        L5a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L63
            r0 = r1
            r4 = r0
            goto L6c
        L63:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = com.google.protobuf.s1.objectFieldOffset(r0)
            goto L22
        L6c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L7d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7e
        L7d:
            r6 = r1
        L7e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L86
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L86:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto Lbe
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto Laf
            int r10 = r10 + 1
            r11[r10] = r9
            goto Ldb
        Laf:
            com.google.protobuf.y$e r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 + 1
            com.google.protobuf.y$e r8 = r8.getEnumVerifier()
            r11[r10] = r8
            goto Ldb
        Lbe:
            if (r9 == 0) goto Lc9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto Ldb
        Lc9:
            com.google.protobuf.y$e r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.protobuf.y$e r8 = r8.getEnumVerifier()
            r11[r10] = r8
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.storeFieldData(com.google.protobuf.s, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(Object obj, int i11, Object obj2) {
        UNSAFE.putObject(obj, offset(typeAndOffsetAt(i11)), obj2);
        setFieldPresent(obj, i11);
    }

    private void storeOneofMessageField(Object obj, int i11, int i12, Object obj2) {
        UNSAFE.putObject(obj, offset(typeAndOffsetAt(i12)), obj2);
        setOneofPresent(obj, i11, i12);
    }

    private static int type(int i11) {
        return (i11 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i11) {
        return this.buffer[i11 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0095. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrder(java.lang.Object r22, com.google.protobuf.Writer r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.writeFieldsInAscendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(java.lang.Object r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            writer.writeMap(i11, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i12)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i11, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i11, (String) obj);
        } else {
            writer.writeBytes(i11, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(o1 o1Var, Object obj, Writer writer) throws IOException {
        o1Var.writeTo(o1Var.getFromMessage(obj), writer);
    }

    @Override // com.google.protobuf.i1
    public boolean equals(Object obj, Object obj2) {
        int length = this.buffer.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            if (!equals(obj, obj2, i11)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(obj).equals(this.unknownFieldSchema.getFromMessage(obj2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(obj).equals(this.extensionSchema.getExtensions(obj2));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0060. Please report as an issue. */
    @Override // com.google.protobuf.i1
    public int getSerializedSize(Object obj) {
        int i11;
        int i12;
        int i13;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        boolean z10;
        int computeSizeFixed32List;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i17);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i17);
            int i19 = this.buffer[i17 + 2];
            int i20 = i19 & i14;
            if (type <= 17) {
                if (i20 != i15) {
                    i16 = i20 == i14 ? 0 : unsafe.getInt(obj, i20);
                    i15 = i20;
                }
                i11 = i15;
                i12 = i16;
                i13 = 1 << (i19 >>> 20);
            } else {
                i11 = i15;
                i12 = i16;
                i13 = 0;
            }
            long offset = offset(typeAndOffsetAt);
            if (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) {
                i20 = 0;
            }
            switch (type) {
                case 0:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i18 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i18 += computeDoubleSize;
                        break;
                    }
                case 2:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(obj, offset));
                        i18 += computeDoubleSize;
                        break;
                    }
                case 3:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(obj, offset));
                        i18 += computeDoubleSize;
                        break;
                    }
                case 4:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(obj, offset));
                        i18 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if (!isFieldPresent(obj, i17, i11, i12, i13)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i18 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i18 += computeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i18 += computeBoolSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        Object object = unsafe.getObject(obj, offset);
                        computeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object);
                        i18 += computeBoolSize;
                    }
                    break;
                case 9:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = k1.computeSizeMessage(numberAt, unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                        i18 += computeBoolSize;
                    }
                    break;
                case 10:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 14:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i18 += computeBoolSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(obj, i17, i11, i12, i13)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (s0) unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                        i18 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = k1.computeSizeFixed64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeBoolSize;
                    break;
                case 19:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeFixed32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 20:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeInt64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 21:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeUInt64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 22:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeInt32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 23:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeFixed64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 24:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeFixed32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 25:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeBoolList(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 26:
                    computeBoolSize = k1.computeSizeStringList(numberAt, (List) unsafe.getObject(obj, offset));
                    i18 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = k1.computeSizeMessageList(numberAt, (List) unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                    i18 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = k1.computeSizeByteStringList(numberAt, (List) unsafe.getObject(obj, offset));
                    i18 += computeBoolSize;
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    computeBoolSize = k1.computeSizeUInt32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeBoolSize;
                    break;
                case 30:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeEnumList(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeFixed32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 32:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeFixed64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 33:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeSInt32List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 34:
                    z10 = false;
                    computeSizeFixed32List = k1.computeSizeSInt64List(numberAt, (List) unsafe.getObject(obj, offset), false);
                    i18 += computeSizeFixed32List;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 36:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 37:
                    computeSizeFixed64ListNoTag = k1.computeSizeInt64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 38:
                    computeSizeFixed64ListNoTag = k1.computeSizeUInt64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 39:
                    computeSizeFixed64ListNoTag = k1.computeSizeInt32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 40:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 41:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 42:
                    computeSizeFixed64ListNoTag = k1.computeSizeBoolListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 43:
                    computeSizeFixed64ListNoTag = k1.computeSizeUInt32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 44:
                    computeSizeFixed64ListNoTag = k1.computeSizeEnumListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 45:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 46:
                    computeSizeFixed64ListNoTag = k1.computeSizeFixed64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case 47:
                    computeSizeFixed64ListNoTag = k1.computeSizeSInt32ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    computeSizeFixed64ListNoTag = k1.computeSizeSInt64ListNoTag((List) unsafe.getObject(obj, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(obj, i20, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i18 += computeSFixed32Size;
                    }
                    break;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    computeBoolSize = k1.computeSizeGroupList(numberAt, (List) unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                    i18 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(obj, offset), getMapFieldDefaultEntry(i17));
                    i18 += computeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i18 += computeBoolSize;
                    }
                    break;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i18 += computeBoolSize;
                    }
                    break;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case AD_VISIBILITY_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i18 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i18 += computeSFixed32Size;
                    }
                    break;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i18 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        Object object2 = unsafe.getObject(obj, offset);
                        computeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        i18 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = k1.computeSizeMessage(numberAt, unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                        i18 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i18 += computeSFixed32Size;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i18 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(obj, offset));
                        i18 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(obj, numberAt, i17)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (s0) unsafe.getObject(obj, offset), getMessageFieldSchema(i17));
                        i18 += computeBoolSize;
                    }
                    break;
            }
            i17 += 3;
            i15 = i11;
            i16 = i12;
            i14 = 1048575;
        }
        int unknownFieldsSerializedSize = i18 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, obj);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(obj).getSerializedSize() : unknownFieldsSerializedSize;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // com.google.protobuf.i1
    public int hashCode(Object obj) {
        int i11;
        int hashLong;
        int length = this.buffer.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i13);
            int numberAt = numberAt(i13);
            long offset = offset(typeAndOffsetAt);
            int i14 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(Double.doubleToLongBits(s1.getDouble(obj, offset)));
                    i12 = i11 + hashLong;
                    break;
                case 1:
                    i11 = i12 * 53;
                    hashLong = Float.floatToIntBits(s1.getFloat(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 2:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(s1.getLong(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 3:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(s1.getLong(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 4:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 5:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(s1.getLong(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 6:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 7:
                    i11 = i12 * 53;
                    hashLong = y.hashBoolean(s1.getBoolean(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 8:
                    i11 = i12 * 53;
                    hashLong = ((String) s1.getObject(obj, offset)).hashCode();
                    i12 = i11 + hashLong;
                    break;
                case 9:
                    Object object = s1.getObject(obj, offset);
                    if (object != null) {
                        i14 = object.hashCode();
                    }
                    i12 = (i12 * 53) + i14;
                    break;
                case 10:
                    i11 = i12 * 53;
                    hashLong = s1.getObject(obj, offset).hashCode();
                    i12 = i11 + hashLong;
                    break;
                case 11:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 12:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 13:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 14:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(s1.getLong(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 15:
                    i11 = i12 * 53;
                    hashLong = s1.getInt(obj, offset);
                    i12 = i11 + hashLong;
                    break;
                case 16:
                    i11 = i12 * 53;
                    hashLong = y.hashLong(s1.getLong(obj, offset));
                    i12 = i11 + hashLong;
                    break;
                case 17:
                    Object object2 = s1.getObject(obj, offset);
                    if (object2 != null) {
                        i14 = object2.hashCode();
                    }
                    i12 = (i12 * 53) + i14;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case NOTIFICATION_REDIRECT_VALUE:
                case 30:
                case TEMPLATE_HTML_SIZE_VALUE:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    i11 = i12 * 53;
                    hashLong = s1.getObject(obj, offset).hashCode();
                    i12 = i11 + hashLong;
                    break;
                case 50:
                    i11 = i12 * 53;
                    hashLong = s1.getObject(obj, offset).hashCode();
                    i12 = i11 + hashLong;
                    break;
                case 51:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(Double.doubleToLongBits(oneofDoubleAt(obj, offset)));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(oneofLongAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(oneofLongAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(oneofLongAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashBoolean(oneofBooleanAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = ((String) s1.getObject(obj, offset)).hashCode();
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = s1.getObject(obj, offset).hashCode();
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = s1.getObject(obj, offset).hashCode();
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(oneofLongAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = oneofIntAt(obj, offset);
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = y.hashLong(oneofLongAt(obj, offset));
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(obj, numberAt, i13)) {
                        i11 = i12 * 53;
                        hashLong = s1.getObject(obj, offset).hashCode();
                        i12 = i11 + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i12 * 53) + this.unknownFieldSchema.getFromMessage(obj).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(obj).hashCode() : hashCode;
    }

    @Override // com.google.protobuf.i1
    public final boolean isInitialized(Object obj) {
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.checkInitializedCount) {
            int i16 = this.intArray[i15];
            int numberAt = numberAt(i16);
            int typeAndOffsetAt = typeAndOffsetAt(i16);
            int i17 = this.buffer[i16 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i13) {
                if (i18 != 1048575) {
                    i14 = UNSAFE.getInt(obj, i18);
                }
                i12 = i14;
                i11 = i18;
            } else {
                i11 = i13;
                i12 = i14;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(obj, i16, i11, i12, i19)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(obj, numberAt, i16) && !isInitialized(obj, typeAndOffsetAt, getMessageFieldSchema(i16))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(obj, typeAndOffsetAt, i16)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(obj, typeAndOffsetAt, i16)) {
                    return false;
                }
            } else if (isFieldPresent(obj, i16, i11, i12, i19) && !isInitialized(obj, typeAndOffsetAt, getMessageFieldSchema(i16))) {
                return false;
            }
            i15++;
            i13 = i11;
            i14 = i12;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(obj).isInitialized();
    }

    @Override // com.google.protobuf.i1
    public void makeImmutable(Object obj) {
        if (isMutable(obj)) {
            if (obj instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i11);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type != 60 && type != 68) {
                        switch (type) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case NOTIFICATION_REDIRECT_VALUE:
                            case 30:
                            case TEMPLATE_HTML_SIZE_VALUE:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                                this.listFieldSchema.makeImmutableListAt(obj, offset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(obj, offset);
                                if (object != null) {
                                    unsafe.putObject(obj, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (isOneofPresent(obj, numberAt(i11), i11)) {
                        getMessageFieldSchema(i11).makeImmutable(UNSAFE.getObject(obj, offset));
                    }
                }
                if (isFieldPresent(obj, i11)) {
                    getMessageFieldSchema(i11).makeImmutable(UNSAFE.getObject(obj, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(obj);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(obj);
            }
        }
    }

    @Override // com.google.protobuf.i1
    public void mergeFrom(Object obj, h1 h1Var, o oVar) throws IOException {
        oVar.getClass();
        checkMutable(obj);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, obj, h1Var, oVar);
    }

    @Override // com.google.protobuf.i1
    public void mergeFrom(Object obj, Object obj2) {
        checkMutable(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.buffer.length; i11 += 3) {
            mergeSingleField(obj, obj2, i11);
        }
        k1.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
        if (this.hasExtensions) {
            k1.mergeExtensions(this.extensionSchema, obj, obj2);
        }
    }

    @Override // com.google.protobuf.i1
    public void mergeFrom(Object obj, byte[] bArr, int i11, int i12, e.b bVar) throws IOException {
        parseMessage(obj, bArr, i11, i12, 0, bVar);
    }

    @Override // com.google.protobuf.i1
    public Object newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0370, code lost:
    
        if (r0 != r8) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0372, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r36;
        r1 = r17;
        r8 = r18;
        r6 = r20;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x038c, code lost:
    
        r8 = r35;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03c2, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03e3, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0095. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int parseMessage(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.protobuf.e.b r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.v0.parseMessage(java.lang.Object, byte[], int, int, int, com.google.protobuf.e$b):int");
    }

    @Override // com.google.protobuf.i1
    public void writeTo(Object obj, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(obj, writer);
        } else {
            writeFieldsInAscendingOrder(obj, writer);
        }
    }
}
