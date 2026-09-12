package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.e;
import com.google.protobuf.s0;
import com.google.protobuf.t;
import com.google.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite extends com.google.protobuf.a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected p1 unknownFields = p1.getDefaultInstance();

    /* loaded from: classes.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* loaded from: classes4.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        SerializedForm(s0 s0Var) {
            this.messageClass = s0Var.getClass();
            this.messageClassName = s0Var.getClass().getName();
            this.asBytes = s0Var.toByteArray();
        }

        public static SerializedForm of(s0 s0Var) {
            return new SerializedForm(s0Var);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((s0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e11) {
                throw new RuntimeException("Unable to understand proto buffer", e11);
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (NoSuchFieldException e14) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e14);
            } catch (SecurityException e15) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e15);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((s0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e11) {
                throw new RuntimeException("Unable to understand proto buffer", e11);
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e14) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b extends a.AbstractC0454a {
        private final GeneratedMessageLite defaultInstance;
        protected GeneratedMessageLite instance;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(GeneratedMessageLite generatedMessageLite) {
            this.defaultInstance = generatedMessageLite;
            if (generatedMessageLite.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = newMutableInstance();
        }

        private static <MessageType> void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            d1.getInstance().schemaFor((d1) messagetype).mergeFrom(messagetype, messagetype2);
        }

        private GeneratedMessageLite newMutableInstance() {
            return this.defaultInstance.newMutableInstance();
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public final GeneratedMessageLite build() {
            GeneratedMessageLite buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0454a.newUninitializedMessageException(buildPartial);
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public GeneratedMessageLite buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public final b clear() {
            if (this.defaultInstance.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = newMutableInstance();
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0454a
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public b mo842clone() {
            b newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.instance = buildPartial();
            return newBuilderForType;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        protected void copyOnWriteInternal() {
            GeneratedMessageLite newMutableInstance = newMutableInstance();
            mergeFromInstance(newMutableInstance, this.instance);
            this.instance = newMutableInstance;
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a, com.google.protobuf.t0
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.a.AbstractC0454a
        public b internalMergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom(generatedMessageLite);
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a, com.google.protobuf.t0
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            if (getDefaultInstanceForType().equals(generatedMessageLite)) {
                return this;
            }
            copyOnWrite();
            mergeFromInstance(this.instance, generatedMessageLite);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public b mergeFrom(i iVar, o oVar) throws IOException {
            copyOnWrite();
            try {
                d1.getInstance().schemaFor((d1) this.instance).mergeFrom(this.instance, j.forCodedInput(iVar), oVar);
                return this;
            } catch (RuntimeException e11) {
                if (e11.getCause() instanceof IOException) {
                    throw ((IOException) e11.getCause());
                }
                throw e11;
            }
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public b mergeFrom(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i11, i12, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.a.AbstractC0454a, com.google.protobuf.s0.a
        public b mergeFrom(byte[] bArr, int i11, int i12, o oVar) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                d1.getInstance().schemaFor((d1) this.instance).mergeFrom(this.instance, bArr, i11, i11 + i12, new e.b(oVar));
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* loaded from: classes4.dex */
    protected static class c extends com.google.protobuf.b {
        private final GeneratedMessageLite defaultInstance;

        public c(GeneratedMessageLite generatedMessageLite) {
            this.defaultInstance = generatedMessageLite;
        }

        @Override // com.google.protobuf.b, com.google.protobuf.b1
        public GeneratedMessageLite parsePartialFrom(i iVar, o oVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, iVar, oVar);
        }

        @Override // com.google.protobuf.b, com.google.protobuf.b1
        public GeneratedMessageLite parsePartialFrom(byte[] bArr, int i11, int i12, o oVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, bArr, i11, i12, oVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class d extends GeneratedMessageLite implements e {
        protected t extensions = t.emptySet();

        /* loaded from: classes4.dex */
        protected class a {
            private final Iterator<Map.Entry<f, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<f, Object> next;

            private a(boolean z10) {
                Iterator it = d.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = (Map.Entry) it.next();
                }
                this.messageSetWireFormat = z10;
            }

            /* synthetic */ a(d dVar, boolean z10, a aVar) {
                this(z10);
            }

            public void writeUntil(int i11, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<f, Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= i11) {
                        return;
                    }
                    f key = this.next.getKey();
                    if (this.messageSetWireFormat && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (s0) this.next.getValue());
                    } else {
                        t.writeField(key, this.next.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        private void eagerlyMergeMessageSetExtension(i iVar, g gVar, o oVar, int i11) throws IOException {
            parseExtension(iVar, oVar, gVar, WireFormat.makeTag(i11, 2), i11);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString byteString, o oVar, g gVar) throws IOException {
            s0 s0Var = (s0) this.extensions.getField(gVar.descriptor);
            s0.a builder = s0Var != null ? s0Var.toBuilder() : null;
            if (builder == null) {
                builder = gVar.getMessageDefaultInstance().newBuilderForType();
            }
            builder.mergeFrom(byteString, oVar);
            ensureExtensionsAreMutable().setField(gVar.descriptor, gVar.singularToFieldSetType(builder.build()));
        }

        private <MessageType extends s0> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, i iVar, o oVar) throws IOException {
            int i11 = 0;
            ByteString byteString = null;
            g gVar = null;
            while (true) {
                int readTag = iVar.readTag();
                if (readTag == 0) {
                    break;
                }
                if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i11 = iVar.readUInt32();
                    if (i11 != 0) {
                        gVar = oVar.findLiteExtensionByNumber(messagetype, i11);
                    }
                } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (i11 == 0 || gVar == null) {
                        byteString = iVar.readBytes();
                    } else {
                        eagerlyMergeMessageSetExtension(iVar, gVar, oVar, i11);
                        byteString = null;
                    }
                } else if (!iVar.skipField(readTag)) {
                    break;
                }
            }
            iVar.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (byteString == null || i11 == 0) {
                return;
            }
            if (gVar != null) {
                mergeMessageSetExtensionFromBytes(byteString, oVar, gVar);
            } else {
                mergeLengthDelimitedField(i11, byteString);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean parseExtension(com.google.protobuf.i r6, com.google.protobuf.o r7, com.google.protobuf.GeneratedMessageLite.g r8, int r9, int r10) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 293
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.d.parseExtension(com.google.protobuf.i, com.google.protobuf.o, com.google.protobuf.GeneratedMessageLite$g, int, int):boolean");
        }

        private void verifyExtensionContainingType(g gVar) {
            if (gVar.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public t ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m843clone();
            }
            return this.extensions;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.a, com.google.protobuf.s0, com.google.protobuf.t0
        public /* bridge */ /* synthetic */ s0 getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.e
        public final <Type> Type getExtension(m mVar) {
            g checkIsLite = GeneratedMessageLite.checkIsLite(mVar);
            verifyExtensionContainingType(checkIsLite);
            Object field = this.extensions.getField(checkIsLite.descriptor);
            return field == null ? (Type) checkIsLite.defaultValue : (Type) checkIsLite.fromFieldSetType(field);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.e
        public final <Type> Type getExtension(m mVar, int i11) {
            g checkIsLite = GeneratedMessageLite.checkIsLite(mVar);
            verifyExtensionContainingType(checkIsLite);
            return (Type) checkIsLite.singularFromFieldSetType(this.extensions.getRepeatedField(checkIsLite.descriptor, i11));
        }

        @Override // com.google.protobuf.GeneratedMessageLite.e
        public final <Type> int getExtensionCount(m mVar) {
            g checkIsLite = GeneratedMessageLite.checkIsLite(mVar);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.getRepeatedFieldCount(checkIsLite.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.e
        public final <Type> boolean hasExtension(m mVar) {
            g checkIsLite = GeneratedMessageLite.checkIsLite(mVar);
            verifyExtensionContainingType(checkIsLite);
            return this.extensions.hasField(checkIsLite.descriptor);
        }

        protected final void mergeExtensionFields(d dVar) {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m843clone();
            }
            this.extensions.mergeFrom(dVar.extensions);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.a, com.google.protobuf.s0
        public /* bridge */ /* synthetic */ s0.a newBuilderForType() {
            return super.newBuilderForType();
        }

        protected com.google.protobuf.GeneratedMessageLite$d.a newExtensionWriter() {
            return new a(this, false, null);
        }

        protected com.google.protobuf.GeneratedMessageLite$d.a newMessageSetExtensionWriter() {
            return new a(this, true, null);
        }

        protected <MessageType extends s0> boolean parseUnknownField(MessageType messagetype, i iVar, o oVar, int i11) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i11);
            return parseExtension(iVar, oVar, oVar.findLiteExtensionByNumber(messagetype, tagFieldNumber), i11, tagFieldNumber);
        }

        protected <MessageType extends s0> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, i iVar, o oVar, int i11) throws IOException {
            if (i11 != WireFormat.MESSAGE_SET_ITEM_TAG) {
                return WireFormat.getTagWireType(i11) == 2 ? parseUnknownField(messagetype, iVar, oVar, i11) : iVar.skipField(i11);
            }
            mergeMessageSetExtensionFromCodedStream(messagetype, iVar, oVar);
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.a, com.google.protobuf.s0
        public /* bridge */ /* synthetic */ s0.a toBuilder() {
            return super.toBuilder();
        }
    }

    /* loaded from: classes4.dex */
    public interface e extends t0 {
        @Override // com.google.protobuf.t0
        /* synthetic */ s0 getDefaultInstanceForType();

        <Type> Type getExtension(m mVar);

        <Type> Type getExtension(m mVar, int i11);

        <Type> int getExtensionCount(m mVar);

        <Type> boolean hasExtension(m mVar);

        @Override // com.google.protobuf.t0
        /* synthetic */ boolean isInitialized();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class f implements t.c {
        final y.d enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        f(y.d dVar, int i11, WireFormat.FieldType fieldType, boolean z10, boolean z11) {
            this.enumTypeMap = dVar;
            this.number = i11;
            this.type = fieldType;
            this.isRepeated = z10;
            this.isPacked = z11;
        }

        @Override // java.lang.Comparable
        public int compareTo(f fVar) {
            return this.number - fVar.number;
        }

        @Override // com.google.protobuf.t.c
        public y.d getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.t.c
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.t.c
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.t.c
        public int getNumber() {
            return this.number;
        }

        @Override // com.google.protobuf.t.c
        public s0.a internalMergeFrom(s0.a aVar, s0 s0Var) {
            return ((b) aVar).mergeFrom((GeneratedMessageLite) s0Var);
        }

        @Override // com.google.protobuf.t.c
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.t.c
        public boolean isRepeated() {
            return this.isRepeated;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends m {
        final s0 containingTypeDefaultInstance;
        final Object defaultValue;
        final f descriptor;
        final s0 messageDefaultInstance;

        g(s0 s0Var, Object obj, s0 s0Var2, f fVar, Class cls) {
            if (s0Var == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (fVar.getLiteType() == WireFormat.FieldType.MESSAGE && s0Var2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.containingTypeDefaultInstance = s0Var;
            this.defaultValue = obj;
            this.messageDefaultInstance = s0Var2;
            this.descriptor = fVar;
        }

        Object fromFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularFromFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(singularFromFieldSetType(it.next()));
            }
            return arrayList;
        }

        public s0 getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // com.google.protobuf.m
        public Object getDefaultValue() {
            return this.defaultValue;
        }

        @Override // com.google.protobuf.m
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // com.google.protobuf.m
        public s0 getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.m
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // com.google.protobuf.m
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        Object singularFromFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.descriptor.enumTypeMap.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        Object singularToFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((y.c) obj).getNumber()) : obj;
        }

        Object toFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularToFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(singularToFieldSetType(it.next()));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends d, BuilderType, T> g checkIsLite(m mVar) {
        if (mVar.isLite()) {
            return (g) mVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite> T checkMessageInitialized(T t11) throws InvalidProtocolBufferException {
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw t11.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t11);
    }

    private int computeSerializedSize(i1 i1Var) {
        return i1Var == null ? d1.getInstance().schemaFor((d1) this).getSerializedSize(this) : i1Var.getSerializedSize(this);
    }

    protected static y.a emptyBooleanList() {
        return com.google.protobuf.f.emptyList();
    }

    protected static y.b emptyDoubleList() {
        return l.emptyList();
    }

    protected static y.f emptyFloatList() {
        return u.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static y.g emptyIntList() {
        return w.emptyList();
    }

    protected static y.i emptyLongList() {
        return k0.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> y.j emptyProtobufList() {
        return e1.emptyList();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == p1.getDefaultInstance()) {
            this.unknownFields = p1.newInstance();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) s1.allocateInstance(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends GeneratedMessageLite> boolean isInitialized(T t11, boolean z10) {
        byte byteValue = ((Byte) t11.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = d1.getInstance().schemaFor((d1) t11).isInitialized(t11);
        if (z10) {
            t11.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t11 : null);
        }
        return isInitialized;
    }

    protected static y.a mutableCopy(y.a aVar) {
        int size = aVar.size();
        return aVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.b mutableCopy(y.b bVar) {
        int size = bVar.size();
        return bVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.f mutableCopy(y.f fVar) {
        int size = fVar.size();
        return fVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static y.g mutableCopy(y.g gVar) {
        int size = gVar.size();
        return gVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.i mutableCopy(y.i iVar) {
        int size = iVar.size();
        return iVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> y.j mutableCopy(y.j jVar) {
        int size = jVar.size();
        return jVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(s0 s0Var, String str, Object[] objArr) {
        return new g1(s0Var, str, objArr);
    }

    public static <ContainingType extends s0, Type> g newRepeatedGeneratedExtension(ContainingType containingtype, s0 s0Var, y.d dVar, int i11, WireFormat.FieldType fieldType, boolean z10, Class cls) {
        return new g(containingtype, Collections.emptyList(), s0Var, new f(dVar, i11, fieldType, true, z10), cls);
    }

    public static <ContainingType extends s0, Type> g newSingularGeneratedExtension(ContainingType containingtype, Type type, s0 s0Var, y.d dVar, int i11, WireFormat.FieldType fieldType, Class cls) {
        return new g(containingtype, type, s0Var, new f(dVar, i11, fieldType, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t11, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t11, inputStream, o.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t11, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t11, inputStream, oVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t11, byteString, o.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, byteString, oVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, i iVar) throws InvalidProtocolBufferException {
        return (T) parseFrom(t11, iVar, o.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, i iVar, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, iVar, oVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, i.newInstance(inputStream), o.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, i.newInstance(inputStream), oVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t11, byteBuffer, o.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t11, i.newInstance(byteBuffer), oVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, bArr, 0, bArr.length, o.getEmptyRegistry()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> T parseFrom(T t11, byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t11, bArr, 0, bArr.length, oVar));
    }

    private static <T extends GeneratedMessageLite> T parsePartialDelimitedFrom(T t11, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            i newInstance = i.newInstance(new a.AbstractC0454a.C0455a(inputStream, i.readRawVarint32(read, inputStream)));
            T t12 = (T) parsePartialFrom(t11, newInstance, oVar);
            try {
                newInstance.checkLastTagWas(0);
                return t12;
            } catch (InvalidProtocolBufferException e11) {
                throw e11.setUnfinishedMessage(t12);
            }
        } catch (InvalidProtocolBufferException e12) {
            if (e12.getThrownFromInputStream()) {
                throw new InvalidProtocolBufferException((IOException) e12);
            }
            throw e12;
        } catch (IOException e13) {
            throw new InvalidProtocolBufferException(e13);
        }
    }

    private static <T extends GeneratedMessageLite> T parsePartialFrom(T t11, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        i newCodedInput = byteString.newCodedInput();
        T t12 = (T) parsePartialFrom(t11, newCodedInput, oVar);
        try {
            newCodedInput.checkLastTagWas(0);
            return t12;
        } catch (InvalidProtocolBufferException e11) {
            throw e11.setUnfinishedMessage(t12);
        }
    }

    protected static <T extends GeneratedMessageLite> T parsePartialFrom(T t11, i iVar) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t11, iVar, o.getEmptyRegistry());
    }

    static <T extends GeneratedMessageLite> T parsePartialFrom(T t11, i iVar, o oVar) throws InvalidProtocolBufferException {
        T t12 = (T) t11.newMutableInstance();
        try {
            i1 schemaFor = d1.getInstance().schemaFor((d1) t12);
            schemaFor.mergeFrom(t12, j.forCodedInput(iVar), oVar);
            schemaFor.makeImmutable(t12);
            return t12;
        } catch (InvalidProtocolBufferException e11) {
            e = e11;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t12);
        } catch (UninitializedMessageException e12) {
            throw e12.asInvalidProtocolBufferException().setUnfinishedMessage(t12);
        } catch (IOException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw new InvalidProtocolBufferException(e13).setUnfinishedMessage(t12);
        } catch (RuntimeException e14) {
            if (e14.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e14.getCause());
            }
            throw e14;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends GeneratedMessageLite> T parsePartialFrom(T t11, byte[] bArr, int i11, int i12, o oVar) throws InvalidProtocolBufferException {
        T t12 = (T) t11.newMutableInstance();
        try {
            i1 schemaFor = d1.getInstance().schemaFor((d1) t12);
            schemaFor.mergeFrom(t12, bArr, i11, i11 + i12, new e.b(oVar));
            schemaFor.makeImmutable(t12);
            return t12;
        } catch (InvalidProtocolBufferException e11) {
            e = e11;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(t12);
        } catch (UninitializedMessageException e12) {
            throw e12.asInvalidProtocolBufferException().setUnfinishedMessage(t12);
        } catch (IOException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw new InvalidProtocolBufferException(e13).setUnfinishedMessage(t12);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(t12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite> void registerDefaultInstance(Class<T> cls, T t11) {
        t11.markImmutable();
        defaultInstanceMap.put(cls, t11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return d1.getInstance().schemaFor((d1) this).hashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom((GeneratedMessageLite) messagetype);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return d1.getInstance().schemaFor((d1) this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0, com.google.protobuf.t0
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.a
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0
    public final b1 getParserForType() {
        return (b1) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    @Override // com.google.protobuf.a
    int getSerializedSize(i1 i1Var) {
        if (!isMutable()) {
            if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
                return getMemoizedSerializedSize();
            }
            int computeSerializedSize = computeSerializedSize(i1Var);
            setMemoizedSerializedSize(computeSerializedSize);
            return computeSerializedSize;
        }
        int computeSerializedSize2 = computeSerializedSize(i1Var);
        if (computeSerializedSize2 >= 0) {
            return computeSerializedSize2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize2);
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0, com.google.protobuf.t0
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMutable() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeImmutable() {
        d1.getInstance().schemaFor((d1) this).makeImmutable(this);
        markImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    protected void mergeLengthDelimitedField(int i11, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(i11, byteString);
    }

    protected final void mergeUnknownFields(p1 p1Var) {
        this.unknownFields = p1.mutableCopyOf(this.unknownFields, p1Var);
    }

    protected void mergeVarintField(int i11, int i12) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(i11, i12);
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0
    public final b newBuilderForType() {
        return (b) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratedMessageLite newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    protected boolean parseUnknownField(int i11, i iVar) throws IOException {
        if (WireFormat.getTagWireType(i11) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(i11, iVar);
    }

    void setMemoizedHashCode(int i11) {
        this.memoizedHashCode = i11;
    }

    @Override // com.google.protobuf.a
    void setMemoizedSerializedSize(int i11) {
        if (i11 >= 0) {
            this.memoizedSerializedSize = (i11 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i11);
        }
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0
    public final b toBuilder() {
        return ((b) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    public String toString() {
        return u0.toString(this, super.toString());
    }

    @Override // com.google.protobuf.a, com.google.protobuf.s0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        d1.getInstance().schemaFor((d1) this).writeTo(this, k.forCodedOutput(codedOutputStream));
    }
}
