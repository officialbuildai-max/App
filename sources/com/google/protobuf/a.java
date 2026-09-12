package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.s0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a implements s0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC0454a implements s0.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.protobuf.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0455a extends FilterInputStream {
            private int limit;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0455a(InputStream inputStream, int i11) {
                super(inputStream);
                this.limit = i11;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i11, int i12) throws IOException {
                int i13 = this.limit;
                if (i13 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i11, Math.min(i12, i13));
                if (read >= 0) {
                    this.limit -= read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j11) throws IOException {
                int skip = (int) super.skip(Math.min(j11, this.limit));
                if (skip >= 0) {
                    this.limit -= skip;
                }
                return skip;
            }
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            y.checkNotNull(iterable);
            if (!(iterable instanceof i0)) {
                if (iterable instanceof c1) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    addAllCheckingNulls(iterable, list);
                    return;
                }
            }
            List<?> underlyingElements = ((i0) iterable).getUnderlyingElements();
            i0 i0Var = (i0) list;
            int size = list.size();
            for (Object obj : underlyingElements) {
                if (obj == null) {
                    String str = "Element at index " + (i0Var.size() - size) + " is null.";
                    for (int size2 = i0Var.size() - 1; size2 >= size; size2--) {
                        i0Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    i0Var.add((ByteString) obj);
                } else {
                    i0Var.add((i0) obj);
                }
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t11 : iterable) {
                if (t11 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t11);
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(s0 s0Var) {
            return new UninitializedMessageException(s0Var);
        }

        @Override // com.google.protobuf.s0.a
        public abstract /* synthetic */ s0 build();

        @Override // com.google.protobuf.s0.a
        public abstract /* synthetic */ s0 buildPartial();

        @Override // com.google.protobuf.s0.a
        public abstract /* synthetic */ s0.a clear();

        @Override // 
        /* renamed from: clone */
        public abstract AbstractC0454a mo842clone();

        @Override // com.google.protobuf.s0.a, com.google.protobuf.t0
        public abstract /* synthetic */ s0 getDefaultInstanceForType();

        protected abstract AbstractC0454a internalMergeFrom(a aVar);

        @Override // com.google.protobuf.s0.a, com.google.protobuf.t0
        public abstract /* synthetic */ boolean isInitialized();

        @Override // com.google.protobuf.s0.a
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.s0.a
        public boolean mergeDelimitedFrom(InputStream inputStream, o oVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0455a(inputStream, i.readRawVarint32(read, inputStream)), oVar);
            return true;
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                i newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e12);
            }
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
            try {
                i newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput, oVar);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e12);
            }
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(i iVar) throws IOException {
            return mergeFrom(iVar, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.s0.a
        public abstract AbstractC0454a mergeFrom(i iVar, o oVar) throws IOException;

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(s0 s0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(s0Var)) {
                return internalMergeFrom((a) s0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(InputStream inputStream) throws IOException {
            i newInstance = i.newInstance(inputStream);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(InputStream inputStream, o oVar) throws IOException {
            i newInstance = i.newInstance(inputStream);
            mergeFrom(newInstance, oVar);
            newInstance.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            try {
                i newInstance = i.newInstance(bArr, i11, i12);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e12);
            }
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(byte[] bArr, int i11, int i12, o oVar) throws InvalidProtocolBufferException {
            try {
                i newInstance = i.newInstance(bArr, i11, i12);
                mergeFrom(newInstance, oVar);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e12);
            }
        }

        @Override // com.google.protobuf.s0.a
        public AbstractC0454a mergeFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length, oVar);
        }
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        AbstractC0454a.addAll((Iterable) iterable, (List) collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        AbstractC0454a.addAll((Iterable) iterable, (List) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.isValidUtf8()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.s0, com.google.protobuf.t0
    public abstract /* synthetic */ s0 getDefaultInstanceForType();

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.s0
    public abstract /* synthetic */ b1 getParserForType();

    @Override // com.google.protobuf.s0
    public abstract /* synthetic */ int getSerializedSize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(i1 i1Var) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int serializedSize = i1Var.getSerializedSize(this);
        setMemoizedSerializedSize(serializedSize);
        return serializedSize;
    }

    @Override // com.google.protobuf.s0, com.google.protobuf.t0
    public abstract /* synthetic */ boolean isInitialized();

    @Override // com.google.protobuf.s0
    public abstract /* synthetic */ s0.a newBuilderForType();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    void setMemoizedSerializedSize(int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.s0
    public abstract /* synthetic */ s0.a toBuilder();

    @Override // com.google.protobuf.s0
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e11);
        }
    }

    @Override // com.google.protobuf.s0
    public ByteString toByteString() {
        try {
            ByteString.f newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.getCodedOutput());
            return newCodedBuilder.build();
        } catch (IOException e11) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e11);
        }
    }

    @Override // com.google.protobuf.s0
    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(serializedSize) + serializedSize));
        newInstance.writeUInt32NoTag(serializedSize);
        writeTo(newInstance);
        newInstance.flush();
    }

    @Override // com.google.protobuf.s0
    public abstract /* synthetic */ void writeTo(CodedOutputStream codedOutputStream) throws IOException;

    @Override // com.google.protobuf.s0
    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(newInstance);
        newInstance.flush();
    }
}
