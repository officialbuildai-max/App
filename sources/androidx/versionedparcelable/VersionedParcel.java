package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class VersionedParcel {

    /* renamed from: a, reason: collision with root package name */
    protected final androidx.collection.a f15302a;

    /* renamed from: b, reason: collision with root package name */
    protected final androidx.collection.a f15303b;

    /* renamed from: c, reason: collision with root package name */
    protected final androidx.collection.a f15304c;

    /* loaded from: classes2.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        this.f15302a = aVar;
        this.f15303b = aVar2;
        this.f15304c = aVar3;
    }

    private void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e11);
        }
    }

    private Class c(Class cls) {
        Class cls2 = (Class) this.f15304c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f15304c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = (Method) this.f15302a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f15302a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) {
        Method method = (Method) this.f15303b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c11 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c11.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f15303b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i11) {
        w(i11);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i11) {
        w(i11);
        C(charSequence);
    }

    protected abstract void E(int i11);

    public void F(int i11, int i12) {
        w(i12);
        E(i11);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i11) {
        w(i11);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i11) {
        w(i11);
        I(str);
    }

    protected void K(c cVar, VersionedParcel versionedParcel) {
        try {
            e(cVar.getClass()).invoke(null, cVar, versionedParcel);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (InvocationTargetException e14) {
            if (!(e14.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e14);
            }
            throw ((RuntimeException) e14.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(c cVar) {
        if (cVar == null) {
            I(null);
            return;
        }
        N(cVar);
        VersionedParcel b11 = b();
        K(cVar, b11);
        b11.a();
    }

    public void M(c cVar, int i11) {
        w(i11);
        L(cVar);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z10, int i11) {
        return !m(i11) ? z10 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i11) {
        return !m(i11) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i11) {
        return !m(i11) ? charSequence : k();
    }

    protected abstract boolean m(int i11);

    protected c n(String str, VersionedParcel versionedParcel) {
        try {
            return (c) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (InvocationTargetException e14) {
            if (e14.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e14.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e14);
        }
    }

    protected abstract int o();

    public int p(int i11, int i12) {
        return !m(i12) ? i11 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i11) {
        return !m(i11) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i11) {
        return !m(i11) ? str : s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c u() {
        String s11 = s();
        if (s11 == null) {
            return null;
        }
        return n(s11, b());
    }

    public c v(c cVar, int i11) {
        return !m(i11) ? cVar : u();
    }

    protected abstract void w(int i11);

    public void x(boolean z10, boolean z11) {
    }

    protected abstract void y(boolean z10);

    public void z(boolean z10, int i11) {
        w(i11);
        y(z10);
    }
}
