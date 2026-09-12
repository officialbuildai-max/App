package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;

/* loaded from: classes5.dex */
public class MethodHandle extends v.a.AbstractC0584a {

    /* renamed from: b, reason: collision with root package name */
    public MethodHandleType f40618b;

    /* renamed from: c, reason: collision with root package name */
    public int f40619c;

    /* renamed from: d, reason: collision with root package name */
    public int f40620d;

    /* renamed from: e, reason: collision with root package name */
    public int f40621e;

    /* loaded from: classes5.dex */
    public enum MethodHandleType {
        METHOD_HANDLE_TYPE_STATIC_PUT(0),
        METHOD_HANDLE_TYPE_STATIC_GET(1),
        METHOD_HANDLE_TYPE_INSTANCE_PUT(2),
        METHOD_HANDLE_TYPE_INSTANCE_GET(3),
        METHOD_HANDLE_TYPE_INVOKE_STATIC(4),
        METHOD_HANDLE_TYPE_INVOKE_INSTANCE(5),
        METHOD_HANDLE_TYPE_INVOKE_DIRECT(6),
        METHOD_HANDLE_TYPE_INVOKE_CONSTRUCTOR(7),
        METHOD_HANDLE_TYPE_INVOKE_INTERFACE(8);

        public final int value;

        MethodHandleType(int i11) {
            this.value = i11;
        }

        public static MethodHandleType fromValue(int i11) {
            for (MethodHandleType methodHandleType : values()) {
                if (methodHandleType.value == i11) {
                    return methodHandleType;
                }
            }
            throw new IllegalArgumentException(String.valueOf(i11));
        }

        public boolean isField() {
            int i11 = a.f40622a[ordinal()];
            return i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4;
        }
    }

    /* loaded from: classes5.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40622a;

        static {
            int[] iArr = new int[MethodHandleType.values().length];
            f40622a = iArr;
            try {
                iArr[MethodHandleType.METHOD_HANDLE_TYPE_STATIC_PUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40622a[MethodHandleType.METHOD_HANDLE_TYPE_STATIC_GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40622a[MethodHandleType.METHOD_HANDLE_TYPE_INSTANCE_PUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40622a[MethodHandleType.METHOD_HANDLE_TYPE_INSTANCE_GET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MethodHandle(int i11, MethodHandleType methodHandleType, int i12, int i13, int i14) {
        super(i11);
        this.f40618b = methodHandleType;
        this.f40619c = i12;
        this.f40620d = i13;
        this.f40621e = i14;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(MethodHandle methodHandle) {
        MethodHandleType methodHandleType = this.f40618b;
        MethodHandleType methodHandleType2 = methodHandle.f40618b;
        return methodHandleType != methodHandleType2 ? methodHandleType.compareTo(methodHandleType2) : gf.c.h(this.f40620d, methodHandle.f40620d);
    }
}
