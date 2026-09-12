package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: classes.dex */
public enum DescriptorProtos$FeatureSet$EnumType implements w.a {
    ENUM_TYPE_UNKNOWN(0),
    OPEN(1),
    CLOSED(2);

    public static final int CLOSED_VALUE = 2;
    public static final int ENUM_TYPE_UNKNOWN_VALUE = 0;
    public static final int OPEN_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$EnumType.a
    };
    private final int value;

    /* loaded from: classes.dex */
    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f8770a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i11) {
            return DescriptorProtos$FeatureSet$EnumType.forNumber(i11) != null;
        }
    }

    DescriptorProtos$FeatureSet$EnumType(int i11) {
        this.value = i11;
    }

    public static DescriptorProtos$FeatureSet$EnumType forNumber(int i11) {
        if (i11 == 0) {
            return ENUM_TYPE_UNKNOWN;
        }
        if (i11 == 1) {
            return OPEN;
        }
        if (i11 != 2) {
            return null;
        }
        return CLOSED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f8770a;
    }

    @Deprecated
    public static DescriptorProtos$FeatureSet$EnumType valueOf(int i11) {
        return forNumber(i11);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
