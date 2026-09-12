package com.alibaba.fastjson;

import a5.g1;
import a5.p0;
import a5.z0;
import com.alibaba.fastjson.util.TypeUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class JSONPath implements com.alibaba.fastjson.b {

    /* renamed from: g, reason: collision with root package name */
    private static ConcurrentMap f18064g = new ConcurrentHashMap(128, 0.75f, 1);

    /* renamed from: a, reason: collision with root package name */
    private final String f18065a;

    /* renamed from: b, reason: collision with root package name */
    private a0[] f18066b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18067c;

    /* renamed from: d, reason: collision with root package name */
    private g1 f18068d;

    /* renamed from: e, reason: collision with root package name */
    private y4.h f18069e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18070f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18071a;

        static {
            int[] iArr = new int[Operator.values().length];
            f18071a = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18071a[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18071a[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18071a[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18071a[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18071a[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a0 {
        Object a(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f18072a;

        public b(int i11) {
            this.f18072a = i11;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.h(obj2, this.f18072a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b0 implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b0 f18073a = new b0();

        b0() {
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.g(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends u {

        /* renamed from: f, reason: collision with root package name */
        private final double f18074f;

        /* renamed from: g, reason: collision with root package name */
        private final Operator f18075g;

        public c(String str, boolean z10, double d11, Operator operator) {
            super(str, z10);
            this.f18074f = d11;
            this.f18075g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null || !(b11 instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) b11).doubleValue();
            switch (a.f18071a[this.f18075g.ordinal()]) {
                case 1:
                    return doubleValue == this.f18074f;
                case 2:
                    return doubleValue != this.f18074f;
                case 3:
                    return doubleValue >= this.f18074f;
                case 4:
                    return doubleValue > this.f18074f;
                case 5:
                    return doubleValue <= this.f18074f;
                case 6:
                    return doubleValue < this.f18074f;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c0 extends u {

        /* renamed from: f, reason: collision with root package name */
        private final String[] f18076f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18077g;

        public c0(String str, boolean z10, String[] strArr, boolean z11) {
            super(str, z10);
            this.f18076f = strArr;
            this.f18077g = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            for (String str : this.f18076f) {
                if (str == b11) {
                    return !this.f18077g;
                }
                if (str != null && str.equals(b11)) {
                    return !this.f18077g;
                }
            }
            return this.f18077g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface d {
        boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d0 extends u {

        /* renamed from: f, reason: collision with root package name */
        private final String f18078f;

        /* renamed from: g, reason: collision with root package name */
        private final Operator f18079g;

        public d0(String str, boolean z10, String str2, Operator operator) {
            super(str, z10);
            this.f18078f = str2;
            this.f18079g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            Operator operator = this.f18079g;
            if (operator == Operator.EQ) {
                return this.f18078f.equals(b11);
            }
            if (operator == Operator.NE) {
                return !this.f18078f.equals(b11);
            }
            if (b11 == null) {
                return false;
            }
            int compareTo = this.f18078f.compareTo(b11.toString());
            Operator operator2 = this.f18079g;
            return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18080a;

        /* renamed from: b, reason: collision with root package name */
        private List f18081b;

        public e(d dVar, d dVar2, boolean z10) {
            ArrayList arrayList = new ArrayList(2);
            this.f18081b = arrayList;
            arrayList.add(dVar);
            this.f18081b.add(dVar2);
            this.f18080a = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.f18080a) {
                Iterator it = this.f18081b.iterator();
                while (it.hasNext()) {
                    if (!((d) it.next()).a(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator it2 = this.f18081b.iterator();
            while (it2.hasNext()) {
                if (((d) it2.next()).a(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class e0 implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e0 f18082a = new e0();

        e0() {
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(JSONPath jSONPath, Object obj, Object obj2) {
            return obj2 == null ? "null" : obj2 instanceof Collection ? "array" : obj2 instanceof Number ? "number" : obj2 instanceof Boolean ? "boolean" : ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? "string" : "object";
        }
    }

    /* loaded from: classes2.dex */
    public static class f implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final d f18083a;

        public f(d dVar) {
            this.f18083a = dVar;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(obj2 instanceof Iterable)) {
                if (this.f18083a.a(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.f18083a.a(jSONPath, obj, obj2, obj3)) {
                    jSONArray.add(obj3);
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f0 extends u {

        /* renamed from: f, reason: collision with root package name */
        private final Object f18084f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f18085g;

        public f0(String str, boolean z10, Object obj, boolean z11) {
            super(str, z10);
            this.f18085g = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.f18084f = obj;
            this.f18085g = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.f18084f.equals(b(jSONPath, obj, obj3));
            return !this.f18085g ? !equals : equals;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final g f18086a = new g();

        g() {
        }

        private static Object b(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor(((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof JSONArray)) {
                return b(obj2);
            }
            JSONArray jSONArray = (JSONArray) ((JSONArray) obj2).clone();
            for (int i11 = 0; i11 < jSONArray.size(); i11++) {
                Object obj3 = jSONArray.get(i11);
                Object b11 = b(obj3);
                if (b11 != obj3) {
                    jSONArray.set(i11, b11);
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g0 implements a0 {

        /* renamed from: c, reason: collision with root package name */
        public static final g0 f18087c = new g0(false, false);

        /* renamed from: d, reason: collision with root package name */
        public static final g0 f18088d = new g0(true, false);

        /* renamed from: e, reason: collision with root package name */
        public static final g0 f18089e = new g0(true, true);

        /* renamed from: a, reason: collision with root package name */
        private boolean f18090a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f18091b;

        private g0(boolean z10, boolean z11) {
            this.f18090a = z10;
            this.f18091b = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.f18090a) {
                return jSONPath.k(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.c(obj2, arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h extends u {

        /* renamed from: f, reason: collision with root package name */
        private final long f18092f;

        /* renamed from: g, reason: collision with root package name */
        private final long f18093g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f18094h;

        public h(String str, boolean z10, long j11, long j12, boolean z11) {
            super(str, z10);
            this.f18092f = j11;
            this.f18093g = j12;
            this.f18094h = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null) {
                return false;
            }
            if (b11 instanceof Number) {
                long D0 = TypeUtils.D0((Number) b11);
                if (D0 >= this.f18092f && D0 <= this.f18093g) {
                    return !this.f18094h;
                }
            }
            return this.f18094h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class i extends u {

        /* renamed from: f, reason: collision with root package name */
        private final long[] f18095f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18096g;

        public i(String str, boolean z10, long[] jArr, boolean z11) {
            super(str, z10);
            this.f18095f = jArr;
            this.f18096g = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null) {
                return false;
            }
            if (b11 instanceof Number) {
                long D0 = TypeUtils.D0((Number) b11);
                for (long j11 : this.f18095f) {
                    if (j11 == D0) {
                        return !this.f18096g;
                    }
                }
            }
            return this.f18096g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class j extends u {

        /* renamed from: f, reason: collision with root package name */
        private final Long[] f18097f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18098g;

        public j(String str, boolean z10, Long[] lArr, boolean z11) {
            super(str, z10);
            this.f18097f = lArr;
            this.f18098g = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            int i11 = 0;
            if (b11 == null) {
                Long[] lArr = this.f18097f;
                int length = lArr.length;
                while (i11 < length) {
                    if (lArr[i11] == null) {
                        return !this.f18098g;
                    }
                    i11++;
                }
                return this.f18098g;
            }
            if (b11 instanceof Number) {
                long D0 = TypeUtils.D0((Number) b11);
                Long[] lArr2 = this.f18097f;
                int length2 = lArr2.length;
                while (i11 < length2) {
                    Long l11 = lArr2[i11];
                    if (l11 != null && l11.longValue() == D0) {
                        return !this.f18098g;
                    }
                    i11++;
                }
            }
            return this.f18098g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class k extends u {

        /* renamed from: f, reason: collision with root package name */
        private final long f18099f;

        /* renamed from: g, reason: collision with root package name */
        private final Operator f18100g;

        /* renamed from: h, reason: collision with root package name */
        private BigDecimal f18101h;

        /* renamed from: i, reason: collision with root package name */
        private Float f18102i;

        /* renamed from: j, reason: collision with root package name */
        private Double f18103j;

        public k(String str, boolean z10, long j11, Operator operator) {
            super(str, z10);
            this.f18099f = j11;
            this.f18100g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null || !(b11 instanceof Number)) {
                return false;
            }
            if (b11 instanceof BigDecimal) {
                if (this.f18101h == null) {
                    this.f18101h = BigDecimal.valueOf(this.f18099f);
                }
                int compareTo = this.f18101h.compareTo((BigDecimal) b11);
                switch (a.f18071a[this.f18100g.ordinal()]) {
                    case 1:
                        return compareTo == 0;
                    case 2:
                        return compareTo != 0;
                    case 3:
                        return compareTo <= 0;
                    case 4:
                        return compareTo < 0;
                    case 5:
                        return compareTo >= 0;
                    case 6:
                        return compareTo > 0;
                    default:
                        return false;
                }
            }
            if (b11 instanceof Float) {
                if (this.f18102i == null) {
                    this.f18102i = Float.valueOf((float) this.f18099f);
                }
                int compareTo2 = this.f18102i.compareTo((Float) b11);
                switch (a.f18071a[this.f18100g.ordinal()]) {
                    case 1:
                        return compareTo2 == 0;
                    case 2:
                        return compareTo2 != 0;
                    case 3:
                        return compareTo2 <= 0;
                    case 4:
                        return compareTo2 < 0;
                    case 5:
                        return compareTo2 >= 0;
                    case 6:
                        return compareTo2 > 0;
                    default:
                        return false;
                }
            }
            if (!(b11 instanceof Double)) {
                long D0 = TypeUtils.D0((Number) b11);
                switch (a.f18071a[this.f18100g.ordinal()]) {
                    case 1:
                        return D0 == this.f18099f;
                    case 2:
                        return D0 != this.f18099f;
                    case 3:
                        return D0 >= this.f18099f;
                    case 4:
                        return D0 > this.f18099f;
                    case 5:
                        return D0 <= this.f18099f;
                    case 6:
                        return D0 < this.f18099f;
                    default:
                        return false;
                }
            }
            if (this.f18103j == null) {
                this.f18103j = Double.valueOf(this.f18099f);
            }
            int compareTo3 = this.f18103j.compareTo((Double) b11);
            switch (a.f18071a[this.f18100g.ordinal()]) {
                case 1:
                    return compareTo3 == 0;
                case 2:
                    return compareTo3 != 0;
                case 3:
                    return compareTo3 <= 0;
                case 4:
                    return compareTo3 < 0;
                case 5:
                    return compareTo3 >= 0;
                case 6:
                    return compareTo3 > 0;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class l {

        /* renamed from: f, reason: collision with root package name */
        private static final Pattern f18104f = Pattern.compile("'\\s*,\\s*'");

        /* renamed from: a, reason: collision with root package name */
        private final String f18105a;

        /* renamed from: b, reason: collision with root package name */
        private int f18106b;

        /* renamed from: c, reason: collision with root package name */
        private char f18107c;

        /* renamed from: d, reason: collision with root package name */
        private int f18108d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f18109e;

        public l(String str) {
            this.f18105a = str;
            i();
        }

        static boolean g(char c11) {
            return c11 == '-' || c11 == '+' || (c11 >= '0' && c11 <= '9');
        }

        void a(char c11) {
            if (this.f18107c == ' ') {
                i();
            }
            if (this.f18107c == c11) {
                if (h()) {
                    return;
                }
                i();
            } else {
                throw new JSONPathException("expect '" + c11 + ", but '" + this.f18107c + "'");
            }
        }

        a0 c(String str) {
            int length = str.length();
            char charAt = str.charAt(0);
            int i11 = length - 1;
            char charAt2 = str.charAt(i11);
            int indexOf = str.indexOf(44);
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                String substring = str.substring(1, i11);
                return (indexOf == -1 || !f18104f.matcher(str).find()) ? new v(substring, false) : new r(substring.split("'\\s*,\\s*'"));
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.v0(str)) {
                    try {
                        return new b(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new v(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new v(str, false);
            }
            if (indexOf != -1) {
                String[] split = str.split(",");
                int[] iArr = new int[split.length];
                for (int i12 = 0; i12 < split.length; i12++) {
                    iArr[i12] = Integer.parseInt(split[i12]);
                }
                return new q(iArr);
            }
            if (indexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] split2 = str.split(":");
            int length2 = split2.length;
            int[] iArr2 = new int[length2];
            for (int i13 = 0; i13 < split2.length; i13++) {
                String str2 = split2[i13];
                if (str2.length() != 0) {
                    iArr2[i13] = Integer.parseInt(str2);
                } else {
                    if (i13 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i13] = 0;
                }
            }
            int i14 = iArr2[0];
            int i15 = length2 > 1 ? iArr2[1] : -1;
            int i16 = length2 == 3 ? iArr2[2] : 1;
            if (i15 < 0 || i15 >= i14) {
                if (i16 > 0) {
                    return new w(i14, i15, i16);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i16);
            }
            throw new UnsupportedOperationException("end must greater than or equals start. start " + i14 + ",  end " + i15);
        }

        public a0[] d() {
            String str = this.f18105a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            a0[] a0VarArr = new a0[8];
            while (true) {
                a0 p11 = p();
                if (p11 == null) {
                    break;
                }
                if (p11 instanceof v) {
                    v vVar = (v) p11;
                    if (!vVar.f18128c && vVar.f18126a.equals("*")) {
                    }
                }
                int i11 = this.f18108d;
                if (i11 == a0VarArr.length) {
                    a0[] a0VarArr2 = new a0[(i11 * 3) / 2];
                    System.arraycopy(a0VarArr, 0, a0VarArr2, 0, i11);
                    a0VarArr = a0VarArr2;
                }
                int i12 = this.f18108d;
                this.f18108d = i12 + 1;
                a0VarArr[i12] = p11;
            }
            int i13 = this.f18108d;
            if (i13 == a0VarArr.length) {
                return a0VarArr;
            }
            a0[] a0VarArr3 = new a0[i13];
            System.arraycopy(a0VarArr, 0, a0VarArr3, 0, i13);
            return a0VarArr3;
        }

        d e(d dVar) {
            char c11 = this.f18107c;
            boolean z10 = true;
            boolean z11 = c11 == '&';
            if ((c11 != '&' || f() != '&') && (this.f18107c != '|' || f() != '|')) {
                return dVar;
            }
            i();
            i();
            if (this.f18107c == '(') {
                i();
            } else {
                z10 = false;
            }
            while (this.f18107c == ' ') {
                i();
            }
            e eVar = new e(dVar, (d) k(false), z11);
            if (z10 && this.f18107c == ')') {
                i();
            }
            return eVar;
        }

        char f() {
            return this.f18105a.charAt(this.f18106b);
        }

        boolean h() {
            return this.f18106b >= this.f18105a.length();
        }

        void i() {
            String str = this.f18105a;
            int i11 = this.f18106b;
            this.f18106b = i11 + 1;
            this.f18107c = str.charAt(i11);
        }

        a0 j(boolean z10) {
            Object k11 = k(z10);
            return k11 instanceof a0 ? (a0) k11 : new f((d) k11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        
            r4 = r26.f18106b;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0119  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object k(boolean r27) {
            /*
                Method dump skipped, instructions count: 1834
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.l.k(boolean):java.lang.Object");
        }

        protected double l(long j11) {
            int i11 = this.f18106b - 1;
            i();
            while (true) {
                char c11 = this.f18107c;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                i();
            }
            return Double.parseDouble(this.f18105a.substring(i11, this.f18106b - 1)) + j11;
        }

        protected long m() {
            int i11 = this.f18106b - 1;
            char c11 = this.f18107c;
            if (c11 == '+' || c11 == '-') {
                i();
            }
            while (true) {
                char c12 = this.f18107c;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                i();
            }
            return Long.parseLong(this.f18105a.substring(i11, this.f18106b - 1));
        }

        String n() {
            s();
            char c11 = this.f18107c;
            if (c11 != '\\' && !Character.isJavaIdentifierStart(c11)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.f18105a);
            }
            StringBuilder sb2 = new StringBuilder();
            while (!h()) {
                char c12 = this.f18107c;
                if (c12 == '\\') {
                    i();
                    sb2.append(this.f18107c);
                    if (h()) {
                        return sb2.toString();
                    }
                    i();
                } else {
                    if (!Character.isJavaIdentifierPart(c12)) {
                        break;
                    }
                    sb2.append(this.f18107c);
                    i();
                }
            }
            if (h() && Character.isJavaIdentifierPart(this.f18107c)) {
                sb2.append(this.f18107c);
            }
            return sb2.toString();
        }

        protected Operator o() {
            Operator operator;
            char c11 = this.f18107c;
            if (c11 == '=') {
                i();
                char c12 = this.f18107c;
                if (c12 == '~') {
                    i();
                    operator = Operator.REG_MATCH;
                } else if (c12 == '=') {
                    i();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c11 == '!') {
                i();
                a('=');
                operator = Operator.NE;
            } else if (c11 == '<') {
                i();
                if (this.f18107c == '=') {
                    i();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c11 == '>') {
                i();
                if (this.f18107c == '=') {
                    i();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String n11 = n();
            if ("not".equalsIgnoreCase(n11)) {
                s();
                String n12 = n();
                if ("like".equalsIgnoreCase(n12)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(n12)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(n12)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(n12)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(n11)) {
                return Operator.NOT_IN;
            }
            if ("like".equalsIgnoreCase(n11)) {
                return Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(n11)) {
                return Operator.RLIKE;
            }
            if ("in".equalsIgnoreCase(n11)) {
                return Operator.IN;
            }
            if ("between".equalsIgnoreCase(n11)) {
                return Operator.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        a0 p() {
            boolean z10;
            if (this.f18108d == 0 && this.f18105a.length() == 1) {
                if (g(this.f18107c)) {
                    return new b(this.f18107c - '0');
                }
                char c11 = this.f18107c;
                if ((c11 >= 'a' && c11 <= 'z') || (c11 >= 'A' && c11 <= 'Z')) {
                    return new v(Character.toString(c11), false);
                }
            }
            while (!h()) {
                s();
                char c12 = this.f18107c;
                if (c12 != '$') {
                    if (c12 != '.' && c12 != '/') {
                        if (c12 == '[') {
                            return j(true);
                        }
                        if (this.f18108d == 0) {
                            return new v(n(), false);
                        }
                        if (c12 == '?') {
                            return new f((d) k(false));
                        }
                        throw new JSONPathException("not support jsonpath : " + this.f18105a);
                    }
                    i();
                    if (c12 == '.' && this.f18107c == '.') {
                        i();
                        int length = this.f18105a.length();
                        int i11 = this.f18106b;
                        if (length > i11 + 3 && this.f18107c == '[' && this.f18105a.charAt(i11) == '*' && this.f18105a.charAt(this.f18106b + 1) == ']' && this.f18105a.charAt(this.f18106b + 2) == '.') {
                            i();
                            i();
                            i();
                            i();
                        }
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    char c13 = this.f18107c;
                    if (c13 == '*' || (z10 && c13 == '[')) {
                        boolean z11 = c13 == '[';
                        if (!h()) {
                            i();
                        }
                        return z10 ? z11 ? g0.f18089e : g0.f18088d : g0.f18087c;
                    }
                    if (g(c13)) {
                        return j(false);
                    }
                    String n11 = n();
                    if (this.f18107c != '(') {
                        return new v(n11, z10);
                    }
                    i();
                    if (this.f18107c != ')') {
                        throw new JSONPathException("not support jsonpath : " + this.f18105a);
                    }
                    if (!h()) {
                        i();
                    }
                    if ("size".equals(n11) || "length".equals(n11)) {
                        return b0.f18073a;
                    }
                    if ("max".equals(n11)) {
                        return o.f18116a;
                    }
                    if ("min".equals(n11)) {
                        return p.f18117a;
                    }
                    if ("keySet".equals(n11)) {
                        return m.f18110a;
                    }
                    if (NativeComponentConstants.KEY_COMPONENT_TYPE.equals(n11)) {
                        return e0.f18082a;
                    }
                    if (PlaceTypes.FLOOR.equals(n11)) {
                        return g.f18086a;
                    }
                    throw new JSONPathException("not support jsonpath : " + this.f18105a);
                }
                i();
                s();
                if (this.f18107c == '?') {
                    return new f((d) k(false));
                }
            }
            return null;
        }

        String q() {
            char c11 = this.f18107c;
            i();
            int i11 = this.f18106b - 1;
            while (this.f18107c != c11 && !h()) {
                i();
            }
            String substring = this.f18105a.substring(i11, h() ? this.f18106b : this.f18106b - 1);
            a(c11);
            return substring;
        }

        protected Object r() {
            s();
            if (g(this.f18107c)) {
                return Long.valueOf(m());
            }
            char c11 = this.f18107c;
            if (c11 == '\"' || c11 == '\'') {
                return q();
            }
            if (c11 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(n())) {
                return null;
            }
            throw new JSONPathException(this.f18105a);
        }

        public final void s() {
            while (true) {
                char c11 = this.f18107c;
                if (c11 > ' ') {
                    return;
                }
                if (c11 != ' ' && c11 != '\r' && c11 != '\n' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                    return;
                } else {
                    i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class m implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final m f18110a = new m();

        m() {
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.f(obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class n extends u {

        /* renamed from: f, reason: collision with root package name */
        private final String f18111f;

        /* renamed from: g, reason: collision with root package name */
        private final String f18112g;

        /* renamed from: h, reason: collision with root package name */
        private final String[] f18113h;

        /* renamed from: i, reason: collision with root package name */
        private final int f18114i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f18115j;

        public n(String str, boolean z10, String str2, String str3, String[] strArr, boolean z11) {
            super(str, z10);
            this.f18111f = str2;
            this.f18112g = str3;
            this.f18113h = strArr;
            this.f18115j = z11;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.f18114i = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i11;
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null) {
                return false;
            }
            String obj4 = b11.toString();
            if (obj4.length() < this.f18114i) {
                return this.f18115j;
            }
            String str = this.f18111f;
            if (str == null) {
                i11 = 0;
            } else {
                if (!obj4.startsWith(str)) {
                    return this.f18115j;
                }
                i11 = this.f18111f.length();
            }
            String[] strArr = this.f18113h;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i11);
                    if (indexOf == -1) {
                        return this.f18115j;
                    }
                    i11 = indexOf + str2.length();
                }
            }
            String str3 = this.f18112g;
            return (str3 == null || obj4.endsWith(str3)) ? !this.f18115j : this.f18115j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class o implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final o f18116a = new o();

        o() {
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.a(obj3, obj4) < 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class p implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public static final p f18117a = new p();

        p() {
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.a(obj3, obj4) > 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class q implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f18118a;

        public q(int[] iArr) {
            this.f18118a = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.f18118a.length);
            int i11 = 0;
            while (true) {
                int[] iArr = this.f18118a;
                if (i11 >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.h(obj2, iArr[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class r implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f18119a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f18120b;

        public r(String[] strArr) {
            this.f18119a = strArr;
            this.f18120b = new long[strArr.length];
            int i11 = 0;
            while (true) {
                long[] jArr = this.f18120b;
                if (i11 >= jArr.length) {
                    return;
                }
                jArr[i11] = TypeUtils.J(strArr[i11]);
                i11++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f18119a.length);
            int i11 = 0;
            while (true) {
                String[] strArr = this.f18119a;
                if (i11 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.j(obj2, strArr[i11], this.f18120b[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class s extends u {
        public s(String str, boolean z10) {
            super(str, z10);
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.j(obj3, this.f18122a, this.f18123b) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class t extends u {
        public t(String str, boolean z10) {
            super(str, z10);
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return b(jSONPath, obj, obj3) == null;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class u implements d {

        /* renamed from: e, reason: collision with root package name */
        static long f18121e = TypeUtils.J(NativeComponentConstants.KEY_COMPONENT_TYPE);

        /* renamed from: a, reason: collision with root package name */
        protected final String f18122a;

        /* renamed from: b, reason: collision with root package name */
        protected final long f18123b;

        /* renamed from: c, reason: collision with root package name */
        protected final boolean f18124c;

        /* renamed from: d, reason: collision with root package name */
        protected a0 f18125d;

        protected u(String str, boolean z10) {
            this.f18122a = str;
            long J = TypeUtils.J(str);
            this.f18123b = J;
            this.f18124c = z10;
            if (z10) {
                if (J == f18121e) {
                    this.f18125d = e0.f18082a;
                } else {
                    if (J == 5614464919154503228L) {
                        this.f18125d = b0.f18073a;
                        return;
                    }
                    throw new JSONPathException("unsupported funciton : " + str);
                }
            }
        }

        protected Object b(JSONPath jSONPath, Object obj, Object obj2) {
            a0 a0Var = this.f18125d;
            return a0Var != null ? a0Var.a(jSONPath, obj, obj2) : jSONPath.j(obj2, this.f18122a, this.f18123b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class v implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final String f18126a;

        /* renamed from: b, reason: collision with root package name */
        private final long f18127b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f18128c;

        public v(String str, boolean z10) {
            this.f18126a = str;
            this.f18127b = TypeUtils.J(str);
            this.f18128c = z10;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.f18128c) {
                return jSONPath.j(obj2, this.f18126a, this.f18127b);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.d(obj2, this.f18126a, arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class w implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f18129a;

        /* renamed from: b, reason: collision with root package name */
        private final int f18130b;

        /* renamed from: c, reason: collision with root package name */
        private final int f18131c;

        public w(int i11, int i12, int i13) {
            this.f18129a = i11;
            this.f18130b = i12;
            this.f18131c = i13;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = b0.f18073a.a(jSONPath, obj, obj2).intValue();
            int i11 = this.f18129a;
            if (i11 < 0) {
                i11 += intValue;
            }
            int i12 = this.f18130b;
            if (i12 < 0) {
                i12 += intValue;
            }
            int i13 = ((i12 - i11) / this.f18131c) + 1;
            if (i13 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i13);
            while (i11 <= i12 && i11 < intValue) {
                arrayList.add(jSONPath.h(obj2, i11));
                i11 += this.f18131c;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class x extends u {

        /* renamed from: f, reason: collision with root package name */
        private final a0 f18132f;

        /* renamed from: g, reason: collision with root package name */
        private final Operator f18133g;

        public x(String str, boolean z10, a0 a0Var, Operator operator) {
            super(str, z10);
            this.f18132f = a0Var;
            this.f18133g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null || !(b11 instanceof Number)) {
                return false;
            }
            Object a11 = this.f18132f.a(jSONPath, obj, obj);
            if ((a11 instanceof Integer) || (a11 instanceof Long) || (a11 instanceof Short) || (a11 instanceof Byte)) {
                long D0 = TypeUtils.D0((Number) a11);
                if ((b11 instanceof Integer) || (b11 instanceof Long) || (b11 instanceof Short) || (b11 instanceof Byte)) {
                    long D02 = TypeUtils.D0((Number) b11);
                    switch (a.f18071a[this.f18133g.ordinal()]) {
                        case 1:
                            return D02 == D0;
                        case 2:
                            return D02 != D0;
                        case 3:
                            return D02 >= D0;
                        case 4:
                            return D02 > D0;
                        case 5:
                            return D02 <= D0;
                        case 6:
                            return D02 < D0;
                    }
                }
                if (b11 instanceof BigDecimal) {
                    int compareTo = BigDecimal.valueOf(D0).compareTo((BigDecimal) b11);
                    switch (a.f18071a[this.f18133g.ordinal()]) {
                        case 1:
                            return compareTo == 0;
                        case 2:
                            return compareTo != 0;
                        case 3:
                            return compareTo <= 0;
                        case 4:
                            return compareTo < 0;
                        case 5:
                            return compareTo >= 0;
                        case 6:
                            return compareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class y extends u {

        /* renamed from: f, reason: collision with root package name */
        private final Pattern f18134f;

        /* renamed from: g, reason: collision with root package name */
        private final Operator f18135g;

        public y(String str, boolean z10, Pattern pattern, Operator operator) {
            super(str, z10);
            this.f18134f = pattern;
            this.f18135g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null) {
                return false;
            }
            return this.f18134f.matcher(b11.toString()).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class z extends u {

        /* renamed from: f, reason: collision with root package name */
        private final Pattern f18136f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18137g;

        public z(String str, boolean z10, String str2, boolean z11) {
            super(str, z10);
            this.f18136f = Pattern.compile(str2);
            this.f18137g = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object b11 = b(jSONPath, obj, obj3);
            if (b11 == null) {
                return false;
            }
            boolean matches = this.f18136f.matcher(b11.toString()).matches();
            return this.f18137g ? !matches : matches;
        }
    }

    public JSONPath(String str) {
        this(str, g1.g(), y4.h.t(), true);
    }

    public JSONPath(String str, g1 g1Var, y4.h hVar, boolean z10) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.f18065a = str;
        this.f18068d = g1Var;
        this.f18069e = hVar;
        this.f18070f = z10;
    }

    static int a(Object obj, Object obj2) {
        Object d11;
        Object f11;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f11 = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new BigDecimal(((Long) obj2).longValue());
            } else {
                if (cls2 != Float.class) {
                    if (cls2 == Double.class) {
                        f11 = new BigDecimal(((Double) obj2).doubleValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
                f11 = new BigDecimal(((Float) obj2).floatValue());
            }
            obj2 = f11;
            return ((Comparable) obj).compareTo(obj2);
        }
        if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f11 = new Long(((Integer) obj2).intValue());
                obj2 = f11;
            } else {
                if (cls2 == BigDecimal.class) {
                    d11 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    d11 = new Float((float) ((Long) obj).longValue());
                } else if (cls2 == Double.class) {
                    d11 = new Double(((Long) obj).longValue());
                }
                obj = d11;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d11 = new Long(((Integer) obj).intValue());
            } else if (cls2 == BigDecimal.class) {
                d11 = new BigDecimal(((Integer) obj).intValue());
            } else if (cls2 == Float.class) {
                d11 = new Float(((Integer) obj).intValue());
            } else if (cls2 == Double.class) {
                d11 = new Double(((Integer) obj).intValue());
            }
            obj = d11;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f11 = new Double(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new Double(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f11 = new Double(((Float) obj2).floatValue());
            }
            obj2 = f11;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f11 = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new Float((float) ((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d11 = new Double(((Float) obj).floatValue());
                obj = d11;
            }
            obj2 = f11;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public static JSONPath b(String str) {
        if (str == null) {
            throw new JSONPathException("jsonpath can not be null");
        }
        JSONPath jSONPath = (JSONPath) f18064g.get(str);
        if (jSONPath != null) {
            return jSONPath;
        }
        JSONPath jSONPath2 = new JSONPath(str);
        if (f18064g.size() >= 1024) {
            return jSONPath2;
        }
        f18064g.putIfAbsent(str, jSONPath2);
        return (JSONPath) f18064g.get(str);
    }

    protected static boolean m(Class cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    protected void c(Object obj, List list) {
        Collection o11;
        Class<?> cls = obj.getClass();
        p0 i11 = i(cls);
        if (i11 != null) {
            try {
                o11 = i11.o(obj);
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.f18065a, e11);
            }
        } else {
            o11 = obj instanceof Map ? ((Map) obj).values() : obj instanceof Collection ? (Collection) obj : null;
        }
        if (o11 == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : o11) {
            if (obj2 == null || y4.h.w(obj2.getClass())) {
                list.add(obj2);
            } else {
                c(obj2, list);
            }
        }
    }

    protected void d(Object obj, String str, List list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !y4.h.w(value.getClass())) {
                    d(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!y4.h.w(obj2.getClass())) {
                    d(obj2, str, list);
                }
            }
            return;
        }
        p0 i11 = i(obj.getClass());
        if (i11 == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i12 = 0; i12 < list2.size(); i12++) {
                    d(list2.get(i12), str, list);
                }
                return;
            }
            return;
        }
        try {
            a5.g0 m11 = i11.m(str);
            if (m11 == null) {
                Iterator it = i11.o(obj).iterator();
                while (it.hasNext()) {
                    d(it.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(m11.d(obj));
                } catch (IllegalAccessException e11) {
                    throw new JSONException("getFieldValue error." + str, e11);
                }
            } catch (InvocationTargetException e12) {
                throw new JSONException("getFieldValue error." + str, e12);
            }
        } catch (Exception e13) {
            throw new JSONPathException("jsonpath error, path " + this.f18065a + ", segement " + str, e13);
        }
    }

    public Object e(Object obj) {
        if (obj == null) {
            return null;
        }
        l();
        int i11 = 0;
        Object obj2 = obj;
        while (true) {
            a0[] a0VarArr = this.f18066b;
            if (i11 >= a0VarArr.length) {
                return obj2;
            }
            obj2 = a0VarArr[i11].a(this, obj, obj2);
            i11++;
        }
    }

    Set f(Object obj) {
        p0 i11;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (i11 = i(obj.getClass())) == null) {
            return null;
        }
        try {
            return i11.k(obj);
        } catch (Exception e11) {
            throw new JSONPathException("evalKeySet error : " + this.f18065a, e11);
        }
    }

    int g(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i11++;
                }
            }
            return i11;
        }
        p0 i12 = i(obj.getClass());
        if (i12 == null) {
            return -1;
        }
        try {
            return i12.r(obj);
        } catch (Exception e11) {
            throw new JSONPathException("evalSize error : " + this.f18065a, e11);
        }
    }

    protected Object h(Object obj, int i11) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i11 >= 0) {
                if (i11 < list.size()) {
                    return list.get(i11);
                }
                return null;
            }
            if (Math.abs(i11) <= list.size()) {
                return list.get(list.size() + i11);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i11 >= 0) {
                if (i11 < length) {
                    return Array.get(obj, i11);
                }
                return null;
            }
            if (Math.abs(i11) <= length) {
                return Array.get(obj, length + i11);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i11));
            return obj2 == null ? map.get(Integer.toString(i11)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            if (i11 == 0) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }
        int i12 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i12 == i11) {
                return obj3;
            }
            i12++;
        }
        return null;
    }

    protected p0 i(Class cls) {
        z0 h11 = this.f18068d.h(cls);
        if (h11 instanceof p0) {
            return (p0) h11;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object j(java.lang.Object r9, java.lang.String r10, long r11) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.j(java.lang.Object, java.lang.String, long):java.lang.Object");
    }

    protected Collection k(Object obj) {
        if (obj == null) {
            return null;
        }
        p0 i11 = i(obj.getClass());
        if (i11 == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
        try {
            return i11.o(obj);
        } catch (Exception e11) {
            throw new JSONPathException("jsonpath error, path " + this.f18065a, e11);
        }
    }

    protected void l() {
        if (this.f18066b != null) {
            return;
        }
        if ("*".equals(this.f18065a)) {
            this.f18066b = new a0[]{g0.f18087c};
            return;
        }
        l lVar = new l(this.f18065a);
        this.f18066b = lVar.d();
        this.f18067c = lVar.f18109e;
    }

    public boolean n() {
        try {
            l();
            int i11 = 0;
            while (true) {
                a0[] a0VarArr = this.f18066b;
                if (i11 >= a0VarArr.length) {
                    return true;
                }
                Class<?> cls = a0VarArr[i11].getClass();
                if (cls != b.class && cls != v.class) {
                    return false;
                }
                i11++;
            }
        } catch (JSONPathException unused) {
            return false;
        }
    }

    @Override // com.alibaba.fastjson.b
    public String toJSONString() {
        return com.alibaba.fastjson.a.toJSONString(this.f18065a);
    }
}
