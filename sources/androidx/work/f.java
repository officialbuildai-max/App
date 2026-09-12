package androidx.work;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final b f15565b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final f f15566c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Map f15567a;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map f15568a = new LinkedHashMap();

        private final a e(String str, Object obj) {
            this.f15568a.put(str, obj);
            return this;
        }

        public final f a() {
            f fVar = new f(this.f15568a);
            f.f15565b.e(fVar);
            return fVar;
        }

        public final a b(String key, Object obj) {
            Intrinsics.h(key, "key");
            Map map = this.f15568a;
            if (obj == null) {
                obj = null;
            } else {
                KClass b11 = Reflection.b(obj.getClass());
                if (!Intrinsics.c(b11, Reflection.b(Boolean.TYPE)) && !Intrinsics.c(b11, Reflection.b(Byte.TYPE)) && !Intrinsics.c(b11, Reflection.b(Integer.TYPE)) && !Intrinsics.c(b11, Reflection.b(Long.TYPE)) && !Intrinsics.c(b11, Reflection.b(Float.TYPE)) && !Intrinsics.c(b11, Reflection.b(Double.TYPE)) && !Intrinsics.c(b11, Reflection.b(String.class)) && !Intrinsics.c(b11, Reflection.b(Boolean[].class)) && !Intrinsics.c(b11, Reflection.b(Byte[].class)) && !Intrinsics.c(b11, Reflection.b(Integer[].class)) && !Intrinsics.c(b11, Reflection.b(Long[].class)) && !Intrinsics.c(b11, Reflection.b(Float[].class)) && !Intrinsics.c(b11, Reflection.b(Double[].class)) && !Intrinsics.c(b11, Reflection.b(String[].class))) {
                    if (Intrinsics.c(b11, Reflection.b(boolean[].class))) {
                        obj = g.h((boolean[]) obj);
                    } else if (Intrinsics.c(b11, Reflection.b(byte[].class))) {
                        obj = g.i((byte[]) obj);
                    } else if (Intrinsics.c(b11, Reflection.b(int[].class))) {
                        obj = g.l((int[]) obj);
                    } else if (Intrinsics.c(b11, Reflection.b(long[].class))) {
                        obj = g.m((long[]) obj);
                    } else if (Intrinsics.c(b11, Reflection.b(float[].class))) {
                        obj = g.k((float[]) obj);
                    } else {
                        if (!Intrinsics.c(b11, Reflection.b(double[].class))) {
                            throw new IllegalArgumentException("Key " + key + " has invalid type " + b11);
                        }
                        obj = g.j((double[]) obj);
                    }
                }
            }
            map.put(key, obj);
            return this;
        }

        public final a c(f data) {
            Intrinsics.h(data, "data");
            d(data.f15567a);
            return this;
        }

        public final a d(Map values) {
            Intrinsics.h(values, "values");
            for (Map.Entry entry : values.entrySet()) {
                b((String) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public final a f(String key, String str) {
            Intrinsics.h(key, "key");
            return e(key, str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final boolean b(ByteArrayInputStream byteArrayInputStream) {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b11 = (byte) (-21267);
            boolean z10 = false;
            if (bArr[0] == ((byte) 16777132) && bArr[1] == b11) {
                z10 = true;
            }
            byteArrayInputStream.reset();
            return z10;
        }

        private static final void c(DataInputStream dataInputStream) {
            short readShort = dataInputStream.readShort();
            if (readShort != -21521) {
                throw new IllegalStateException(("Magic number doesn't match: " + ((int) readShort)).toString());
            }
            short readShort2 = dataInputStream.readShort();
            if (readShort2 == 1) {
                return;
            }
            throw new IllegalStateException(("Unsupported version number: " + ((int) readShort2)).toString());
        }

        private static final Object d(DataInputStream dataInputStream, byte b11) {
            if (b11 == 0) {
                return null;
            }
            if (b11 == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b11 == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b11 == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b11 == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b11 == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b11 == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b11 == 7) {
                return dataInputStream.readUTF();
            }
            int i11 = 0;
            if (b11 == 8) {
                int readInt = dataInputStream.readInt();
                Boolean[] boolArr = new Boolean[readInt];
                while (i11 < readInt) {
                    boolArr[i11] = Boolean.valueOf(dataInputStream.readBoolean());
                    i11++;
                }
                return boolArr;
            }
            if (b11 == 9) {
                int readInt2 = dataInputStream.readInt();
                Byte[] bArr = new Byte[readInt2];
                while (i11 < readInt2) {
                    bArr[i11] = Byte.valueOf(dataInputStream.readByte());
                    i11++;
                }
                return bArr;
            }
            if (b11 == 10) {
                int readInt3 = dataInputStream.readInt();
                Integer[] numArr = new Integer[readInt3];
                while (i11 < readInt3) {
                    numArr[i11] = Integer.valueOf(dataInputStream.readInt());
                    i11++;
                }
                return numArr;
            }
            if (b11 == 11) {
                int readInt4 = dataInputStream.readInt();
                Long[] lArr = new Long[readInt4];
                while (i11 < readInt4) {
                    lArr[i11] = Long.valueOf(dataInputStream.readLong());
                    i11++;
                }
                return lArr;
            }
            if (b11 == 12) {
                int readInt5 = dataInputStream.readInt();
                Float[] fArr = new Float[readInt5];
                while (i11 < readInt5) {
                    fArr[i11] = Float.valueOf(dataInputStream.readFloat());
                    i11++;
                }
                return fArr;
            }
            if (b11 == 13) {
                int readInt6 = dataInputStream.readInt();
                Double[] dArr = new Double[readInt6];
                while (i11 < readInt6) {
                    dArr[i11] = Double.valueOf(dataInputStream.readDouble());
                    i11++;
                }
                return dArr;
            }
            if (b11 != 14) {
                throw new IllegalStateException("Unsupported type " + ((int) b11));
            }
            int readInt7 = dataInputStream.readInt();
            String[] strArr = new String[readInt7];
            while (i11 < readInt7) {
                String readUTF = dataInputStream.readUTF();
                if (Intrinsics.c(readUTF, "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d")) {
                    readUTF = null;
                }
                strArr[i11] = readUTF;
                i11++;
            }
            return strArr;
        }

        private static final void f(DataOutputStream dataOutputStream, Object[] objArr) {
            int i11;
            KClass b11 = Reflection.b(objArr.getClass());
            if (Intrinsics.c(b11, Reflection.b(Boolean[].class))) {
                i11 = 8;
            } else if (Intrinsics.c(b11, Reflection.b(Byte[].class))) {
                i11 = 9;
            } else if (Intrinsics.c(b11, Reflection.b(Integer[].class))) {
                i11 = 10;
            } else if (Intrinsics.c(b11, Reflection.b(Long[].class))) {
                i11 = 11;
            } else if (Intrinsics.c(b11, Reflection.b(Float[].class))) {
                i11 = 12;
            } else if (Intrinsics.c(b11, Reflection.b(Double[].class))) {
                i11 = 13;
            } else {
                if (!Intrinsics.c(b11, Reflection.b(String[].class))) {
                    throw new IllegalArgumentException("Unsupported value type " + Reflection.b(objArr.getClass()).f());
                }
                i11 = 14;
            }
            dataOutputStream.writeByte(i11);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                if (i11 == 8) {
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                } else if (i11 == 9) {
                    Byte b12 = obj instanceof Byte ? (Byte) obj : null;
                    dataOutputStream.writeByte(b12 != null ? b12.byteValue() : (byte) 0);
                } else if (i11 == 10) {
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                } else if (i11 == 11) {
                    Long l11 = obj instanceof Long ? (Long) obj : null;
                    dataOutputStream.writeLong(l11 != null ? l11.longValue() : 0L);
                } else if (i11 == 12) {
                    Float f11 = obj instanceof Float ? (Float) obj : null;
                    dataOutputStream.writeFloat(f11 != null ? f11.floatValue() : 0.0f);
                } else if (i11 == 13) {
                    Double d11 = obj instanceof Double ? (Double) obj : null;
                    dataOutputStream.writeDouble(d11 != null ? d11.doubleValue() : 0.0d);
                } else if (i11 == 14) {
                    String str = obj instanceof String ? (String) obj : null;
                    if (str == null) {
                        str = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
                    }
                    dataOutputStream.writeUTF(str);
                }
            }
        }

        private static final void g(DataOutputStream dataOutputStream, String str, Object obj) {
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalArgumentException("Unsupported value type " + Reflection.b(obj.getClass()).g());
                }
                f(dataOutputStream, (Object[]) obj);
            }
            dataOutputStream.writeUTF(str);
        }

        private static final void h(DataOutputStream dataOutputStream) {
            dataOutputStream.writeShort(-21521);
            dataOutputStream.writeShort(1);
        }

        public final f a(byte[] bytes) {
            String str;
            String str2;
            Intrinsics.h(bytes, "bytes");
            if (bytes.length > 10240) {
                throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            }
            if (bytes.length == 0) {
                return f.f15566c;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                int i11 = 0;
                if (b(byteArrayInputStream)) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        int readInt = objectInputStream.readInt();
                        while (i11 < readInt) {
                            linkedHashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                            i11++;
                        }
                        CloseableKt.a(objectInputStream, null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.a(objectInputStream, th2);
                            throw th3;
                        }
                    }
                } else {
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    try {
                        c(dataInputStream);
                        int readInt2 = dataInputStream.readInt();
                        while (i11 < readInt2) {
                            linkedHashMap.put(dataInputStream.readUTF(), d(dataInputStream, dataInputStream.readByte()));
                            i11++;
                        }
                        CloseableKt.a(dataInputStream, null);
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.a(dataInputStream, th4);
                            throw th5;
                        }
                    }
                }
            } catch (IOException e11) {
                str2 = g.f15569a;
                t.e().d(str2, "Error in Data#fromByteArray: ", e11);
            } catch (ClassNotFoundException e12) {
                str = g.f15569a;
                t.e().d(str, "Error in Data#fromByteArray: ", e12);
            }
            return new f(linkedHashMap);
        }

        public final byte[] e(f data) {
            String str;
            Intrinsics.h(data, "data");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    h(dataOutputStream);
                    dataOutputStream.writeInt(data.i());
                    for (Map.Entry entry : data.f15567a.entrySet()) {
                        g(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.a(dataOutputStream, null);
                    Intrinsics.e(byteArray);
                    return byteArray;
                } finally {
                }
            } catch (IOException e11) {
                str = g.f15569a;
                t.e().d(str, "Error in Data#toByteArray: ", e11);
                return new byte[0];
            }
        }
    }

    public f(f other) {
        Intrinsics.h(other, "other");
        this.f15567a = new HashMap(other.f15567a);
    }

    public f(Map values) {
        Intrinsics.h(values, "values");
        this.f15567a = new HashMap(values);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence j(Map.Entry entry) {
        Intrinsics.h(entry, "<destruct>");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" : ");
        if (value instanceof Object[]) {
            value = Arrays.toString((Object[]) value);
            Intrinsics.g(value, "toString(...)");
        }
        sb2.append(value);
        return sb2.toString();
    }

    public final boolean c(String key, boolean z10) {
        Intrinsics.h(key, "key");
        Object valueOf = Boolean.valueOf(z10);
        Object obj = this.f15567a.get(key);
        if (obj instanceof Boolean) {
            valueOf = obj;
        }
        return ((Boolean) valueOf).booleanValue();
    }

    public final int d(String key, int i11) {
        Intrinsics.h(key, "key");
        Object valueOf = Integer.valueOf(i11);
        Object obj = this.f15567a.get(key);
        if (obj instanceof Integer) {
            valueOf = obj;
        }
        return ((Number) valueOf).intValue();
    }

    public final Map e() {
        Map unmodifiableMap = Collections.unmodifiableMap(this.f15567a);
        Intrinsics.g(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(f.class, obj.getClass())) {
            return false;
        }
        f fVar = (f) obj;
        Set<String> keySet = this.f15567a.keySet();
        if (!Intrinsics.c(keySet, fVar.f15567a.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.f15567a.get(str);
            Object obj3 = fVar.f15567a.get(str);
            if (obj2 == null || obj3 == null) {
                z10 = obj2 == obj3;
            } else {
                if (obj2 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj2;
                    if (obj3 instanceof Object[]) {
                        z10 = ArraysKt.d(objArr, (Object[]) obj3);
                    }
                }
                z10 = Intrinsics.c(obj2, obj3);
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public final long f(String key, long j11) {
        Intrinsics.h(key, "key");
        Object valueOf = Long.valueOf(j11);
        Object obj = this.f15567a.get(key);
        if (obj instanceof Long) {
            valueOf = obj;
        }
        return ((Number) valueOf).longValue();
    }

    public final String g(String key) {
        Intrinsics.h(key, "key");
        Object obj = this.f15567a.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final boolean h(String key, Class klass) {
        Intrinsics.h(key, "key");
        Intrinsics.h(klass, "klass");
        Object obj = this.f15567a.get(key);
        return obj != null && klass.isAssignableFrom(obj.getClass());
    }

    public int hashCode() {
        int i11 = 0;
        for (Map.Entry entry : this.f15567a.entrySet()) {
            Object value = entry.getValue();
            i11 += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ ArraysKt.b((Object[]) value) : entry.hashCode();
        }
        return i11 * 31;
    }

    public final int i() {
        return this.f15567a.size();
    }

    public String toString() {
        return "Data {" + CollectionsKt.s0(this.f15567a.entrySet(), null, null, null, 0, null, new Function1() { // from class: androidx.work.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence j11;
                j11 = f.j((Map.Entry) obj);
                return j11;
            }
        }, 31, null) + "}";
    }
}
