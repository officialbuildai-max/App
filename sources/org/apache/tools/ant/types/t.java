package org.apache.tools.ant.types;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class t extends e implements Cloneable, Comparable, u {

    /* renamed from: f, reason: collision with root package name */
    protected static final int f71656f = g("Resource".getBytes());

    /* renamed from: g, reason: collision with root package name */
    private static final int f71657g = g("null name".getBytes());

    /* renamed from: a, reason: collision with root package name */
    private String f71658a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f71659b;

    /* renamed from: c, reason: collision with root package name */
    private Long f71660c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f71661d;

    /* renamed from: e, reason: collision with root package name */
    private Long f71662e;

    public t() {
        this.f71658a = null;
        this.f71659b = null;
        this.f71660c = null;
        this.f71661d = null;
        this.f71662e = null;
    }

    public t(String str) {
        this(str, false, 0L, false);
    }

    public t(String str, boolean z10, long j11, boolean z11) {
        this(str, z10, j11, z11, -1L);
    }

    public t(String str, boolean z10, long j11, boolean z11, long j12) {
        this.f71659b = null;
        this.f71660c = null;
        this.f71661d = null;
        this.f71662e = null;
        this.f71658a = str;
        o(str);
        m(z10);
        n(j11);
        l(z11);
        p(j12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int g(byte[] bArr) {
        return new BigInteger(bArr).intValue();
    }

    @Override // org.apache.tools.ant.types.u
    public boolean a() {
        return isReference() && ((t) getCheckedRef()).a();
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("CloneNotSupportedException for a Resource caught. Derived classes must support cloning.");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (obj instanceof t) {
            return toString().compareTo(obj.toString());
        }
        throw new IllegalArgumentException("Can only be compared with Resources");
    }

    public InputStream e() {
        if (isReference()) {
            return ((t) getCheckedRef()).e();
        }
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return isReference() ? getCheckedRef().equals(obj) : obj.getClass().equals(getClass()) && compareTo(obj) == 0;
    }

    public long f() {
        Long l11;
        if (isReference()) {
            return ((t) getCheckedRef()).f();
        }
        if (!k() || (l11 = this.f71660c) == null) {
            return 0L;
        }
        long longValue = l11.longValue();
        if (longValue < 0) {
            return 0L;
        }
        return longValue;
    }

    public String getName() {
        return isReference() ? ((t) getCheckedRef()).getName() : this.f71658a;
    }

    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        String name = getName();
        return f71656f * (name == null ? f71657g : name.hashCode());
    }

    public long i() {
        if (isReference()) {
            return ((t) getCheckedRef()).i();
        }
        if (!k()) {
            return 0L;
        }
        Long l11 = this.f71662e;
        if (l11 != null) {
            return l11.longValue();
        }
        return -1L;
    }

    @Override // org.apache.tools.ant.types.u
    public Iterator iterator() {
        return isReference() ? ((t) getCheckedRef()).iterator() : new s(this);
    }

    public boolean j() {
        if (isReference()) {
            return ((t) getCheckedRef()).j();
        }
        Boolean bool = this.f71661d;
        return bool != null && bool.booleanValue();
    }

    public boolean k() {
        if (isReference()) {
            return ((t) getCheckedRef()).k();
        }
        Boolean bool = this.f71659b;
        return bool == null || bool.booleanValue();
    }

    public void l(boolean z10) {
        checkAttributesAllowed();
        this.f71661d = z10 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void m(boolean z10) {
        checkAttributesAllowed();
        this.f71659b = z10 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void n(long j11) {
        checkAttributesAllowed();
        this.f71660c = new Long(j11);
    }

    public void o(String str) {
        checkAttributesAllowed();
        this.f71658a = str;
    }

    public void p(long j11) {
        checkAttributesAllowed();
        if (j11 <= -1) {
            j11 = -1;
        }
        this.f71662e = new Long(j11);
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f71658a != null || this.f71659b != null || this.f71660c != null || this.f71661d != null || this.f71662e != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public int size() {
        if (isReference()) {
            return ((t) getCheckedRef()).size();
        }
        return 1;
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        String name = getName();
        return name == null ? "(anonymous)" : name;
    }
}
