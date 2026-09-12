package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.b1;
import com.google.protobuf.t0;
import com.google.protobuf.y;

/* loaded from: classes.dex */
public final class TransportInfo extends GeneratedMessageLite implements t0 {
    private static final TransportInfo DEFAULT_INSTANCE;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    private static volatile b1 PARSER;
    private int bitField0_;
    private int dispatchDestination_;

    /* loaded from: classes4.dex */
    public enum DispatchDestination implements y.c {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);

        public static final int FL_LEGACY_V1_VALUE = 1;
        public static final int SOURCE_UNKNOWN_VALUE = 0;
        private static final y.d internalValueMap = new a();
        private final int value;

        /* loaded from: classes4.dex */
        class a implements y.d {
            a() {
            }

            @Override // com.google.protobuf.y.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DispatchDestination findValueByNumber(int i11) {
                return DispatchDestination.forNumber(i11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b implements y.e {

            /* renamed from: a, reason: collision with root package name */
            static final y.e f32444a = new b();

            private b() {
            }

            @Override // com.google.protobuf.y.e
            public boolean isInRange(int i11) {
                return DispatchDestination.forNumber(i11) != null;
            }
        }

        DispatchDestination(int i11) {
            this.value = i11;
        }

        public static DispatchDestination forNumber(int i11) {
            if (i11 == 0) {
                return SOURCE_UNKNOWN;
            }
            if (i11 != 1) {
                return null;
            }
            return FL_LEGACY_V1;
        }

        public static y.d internalGetValueMap() {
            return internalValueMap;
        }

        public static y.e internalGetVerifier() {
            return b.f32444a;
        }

        @Deprecated
        public static DispatchDestination valueOf(int i11) {
            return forNumber(i11);
        }

        @Override // com.google.protobuf.y.c
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes4.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32445a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32445a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.b implements t0 {
        private b() {
            super(TransportInfo.DEFAULT_INSTANCE);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        TransportInfo transportInfo = new TransportInfo();
        DEFAULT_INSTANCE = transportInfo;
        GeneratedMessageLite.registerDefaultInstance(TransportInfo.class, transportInfo);
    }

    private TransportInfo() {
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        a aVar = null;
        switch (a.f32445a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransportInfo();
            case 2:
                return new b(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"bitField0_", "dispatchDestination_", DispatchDestination.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                b1 b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (TransportInfo.class) {
                        try {
                            b1Var = PARSER;
                            if (b1Var == null) {
                                b1Var = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = b1Var;
                            }
                        } finally {
                        }
                    }
                }
                return b1Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
