package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(w.f9000d);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final d byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i11, int i12) {
            super(bArr);
            ByteString.checkRange(i11, i11 + i12, bArr.length);
            this.bytesOffset = i11;
            this.bytesLength = i12;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i11) {
            ByteString.checkIndex(i11, size());
            return this.bytes[this.bytesOffset + i11];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i11, bArr, i12, i13);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        byte internalByteAt(int i11) {
            return this.bytes[this.bytesOffset + i11];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* loaded from: classes.dex */
    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        private LeafByteString() {
        }

        /* synthetic */ LeafByteString(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean equalsRange(ByteString byteString, int i11, int i12);

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        void writeToReverse(androidx.datastore.preferences.protobuf.h hVar) throws IOException {
            writeTo(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i11) {
            return this.bytes[i11];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, i11, bArr, i12, i13);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString byteString, int i11, int i12) {
            if (i12 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i12 + size());
            }
            int i13 = i11 + i12;
            if (i13 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i11 + ", " + i12 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i11, i13).equals(substring(0, i12));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i12;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i11;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        protected int getOffsetIntoBytes() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        byte internalByteAt(int i11) {
            return this.bytes[i11];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.s(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final i newCodedInput() {
            return i.m(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int partialHash(int i11, int i12, int i13) {
            return w.g(i11, this.bytes, getOffsetIntoBytes() + i12, i13);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int partialIsValidUtf8(int i11, int i12, int i13) {
            int offsetIntoBytes = getOffsetIntoBytes() + i12;
            return Utf8.u(i11, this.bytes, offsetIntoBytes, i13 + offsetIntoBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString substring(int i11, int i12) {
            int checkRange = ByteString.checkRange(i11, i12, size());
            return checkRange == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, getOffsetIntoBytes() + i11, checkRange);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        final void writeTo(androidx.datastore.preferences.protobuf.h hVar) throws IOException {
            hVar.b(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class NioByteString extends LeafByteString {
        private final ByteBuffer buffer;

        /* loaded from: classes.dex */
        class a extends InputStream {

            /* renamed from: a, reason: collision with root package name */
            private final ByteBuffer f8742a;

            a() {
                this.f8742a = NioByteString.this.buffer.slice();
            }

            @Override // java.io.InputStream
            public int available() {
                return this.f8742a.remaining();
            }

            @Override // java.io.InputStream
            public void mark(int i11) {
                y.b(this.f8742a);
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.f8742a.hasRemaining()) {
                    return this.f8742a.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i11, int i12) {
                if (!this.f8742a.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i12, this.f8742a.remaining());
                this.f8742a.get(bArr, i11, min);
                return min;
            }

            @Override // java.io.InputStream
            public void reset() {
                try {
                    y.d(this.f8742a);
                } catch (InvalidMarkException e11) {
                    throw new IOException(e11);
                }
            }
        }

        NioByteString(ByteBuffer byteBuffer) {
            super(null);
            w.b(byteBuffer, "buffer");
            this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
        }

        private ByteBuffer a(int i11, int i12) {
            if (i11 < this.buffer.position() || i12 > this.buffer.limit() || i11 > i12) {
                throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            ByteBuffer slice = this.buffer.slice();
            y.c(slice, i11 - this.buffer.position());
            y.a(slice, i12 - this.buffer.position());
            return slice;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
        }

        private Object writeReplace() {
            return ByteString.copyFrom(this.buffer.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteBuffer asReadOnlyByteBuffer() {
            return this.buffer.asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i11) {
            try {
                return this.buffer.get(i11);
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw e11;
            } catch (IndexOutOfBoundsException e12) {
                throw new ArrayIndexOutOfBoundsException(e12.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.buffer.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            ByteBuffer slice = this.buffer.slice();
            y.c(slice, i11);
            slice.get(bArr, i12, i13);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString)) {
                return false;
            }
            ByteString byteString = (ByteString) obj;
            if (size() != byteString.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            return obj instanceof NioByteString ? this.buffer.equals(((NioByteString) obj).buffer) : obj instanceof RopeByteString ? obj.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public boolean equalsRange(ByteString byteString, int i11, int i12) {
            return substring(0, i12).equals(byteString.substring(i11, i12 + i11));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte internalByteAt(int i11) {
            return byteAt(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public boolean isValidUtf8() {
            return Utf8.r(this.buffer);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public i newCodedInput() {
            return i.j(this.buffer, true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public InputStream newInput() {
            return new a();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected int partialHash(int i11, int i12, int i13) {
            for (int i14 = i12; i14 < i12 + i13; i14++) {
                i11 = (i11 * 31) + this.buffer.get(i14);
            }
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected int partialIsValidUtf8(int i11, int i12, int i13) {
            return Utf8.t(i11, this.buffer, i12, i13 + i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.buffer.remaining();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteString substring(int i11, int i12) {
            try {
                return new NioByteString(a(i11, i12));
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw e11;
            } catch (IndexOutOfBoundsException e12) {
                throw new ArrayIndexOutOfBoundsException(e12.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected String toStringInternal(Charset charset) {
            byte[] byteArray;
            int length;
            int i11;
            if (this.buffer.hasArray()) {
                byteArray = this.buffer.array();
                i11 = this.buffer.arrayOffset() + this.buffer.position();
                length = this.buffer.remaining();
            } else {
                byteArray = toByteArray();
                length = byteArray.length;
                i11 = 0;
            }
            return new String(byteArray, i11, length, charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        void writeTo(androidx.datastore.preferences.protobuf.h hVar) throws IOException {
            hVar.a(this.buffer.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
            if (!this.buffer.hasArray()) {
                androidx.datastore.preferences.protobuf.g.g(a(i11, i12 + i11), outputStream);
            } else {
                outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i11, i12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private int f8744a = 0;

        /* renamed from: b, reason: collision with root package name */
        private final int f8745b;

        a() {
            this.f8745b = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8744a < this.f8745b;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.e
        public byte nextByte() {
            int i11 = this.f8744a;
            if (i11 >= this.f8745b) {
                throw new NoSuchElementException();
            }
            this.f8744a = i11 + 1;
            return ByteString.this.internalByteAt(i11);
        }
    }

    /* loaded from: classes.dex */
    static abstract class b implements e {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements d {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.d
        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            return Arrays.copyOfRange(bArr, i11, i12 + i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        byte[] copyFrom(byte[] bArr, int i11, int i12);
    }

    /* loaded from: classes.dex */
    public interface e extends Iterator {
        byte nextByte();
    }

    /* loaded from: classes.dex */
    static final class f {

        /* renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f8747a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f8748b;

        private f(int i11) {
            byte[] bArr = new byte[i11];
            this.f8748b = bArr;
            this.f8747a = CodedOutputStream.d0(bArr);
        }

        /* synthetic */ f(int i11, a aVar) {
            this(i11);
        }

        public ByteString a() {
            this.f8747a.d();
            return new LiteralByteString(this.f8748b);
        }

        public CodedOutputStream b() {
            return this.f8747a;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends OutputStream {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f8749f = new byte[0];

        /* renamed from: a, reason: collision with root package name */
        private final int f8750a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList f8751b;

        /* renamed from: c, reason: collision with root package name */
        private int f8752c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f8753d;

        /* renamed from: e, reason: collision with root package name */
        private int f8754e;

        g(int i11) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f8750a = i11;
            this.f8751b = new ArrayList();
            this.f8753d = new byte[i11];
        }

        private void b(int i11) {
            this.f8751b.add(new LiteralByteString(this.f8753d));
            int length = this.f8752c + this.f8753d.length;
            this.f8752c = length;
            this.f8753d = new byte[Math.max(this.f8750a, Math.max(i11, length >>> 1))];
            this.f8754e = 0;
        }

        public synchronized int d() {
            return this.f8752c + this.f8754e;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i11) {
            try {
                if (this.f8754e == this.f8753d.length) {
                    b(1);
                }
                byte[] bArr = this.f8753d;
                int i12 = this.f8754e;
                this.f8754e = i12 + 1;
                bArr[i12] = (byte) i11;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i11, int i12) {
            try {
                byte[] bArr2 = this.f8753d;
                int length = bArr2.length;
                int i13 = this.f8754e;
                if (i12 <= length - i13) {
                    System.arraycopy(bArr, i11, bArr2, i13, i12);
                    this.f8754e += i12;
                } else {
                    int length2 = bArr2.length - i13;
                    System.arraycopy(bArr, i11, bArr2, i13, length2);
                    int i14 = i12 - length2;
                    b(i14);
                    System.arraycopy(bArr, i11 + length2, this.f8753d, 0, i14);
                    this.f8754e = i14;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class h implements d {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.d
        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            return bArr2;
        }
    }

    static {
        a aVar = null;
        byteArrayCopier = androidx.datastore.preferences.protobuf.d.c() ? new h(aVar) : new c(aVar);
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: androidx.datastore.preferences.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.ByteString$e, java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [androidx.datastore.preferences.protobuf.ByteString$e, java.util.Iterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? iterator2 = byteString.iterator2();
                ?? iterator22 = byteString2.iterator2();
                while (iterator2.hasNext() && iterator22.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.toInt(iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(iterator22.nextByte())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i11)));
        }
        if (i11 == 1) {
            return it.next();
        }
        int i12 = i11 >>> 1;
        return balancedConcat(it, i12).concat(balancedConcat(it, i11 - i12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkIndex(int i11, int i12) {
        if (((i12 - (i11 + 1)) | i11) < 0) {
            if (i11 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + ", " + i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkRange(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i11 + " < 0");
        }
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i11 + ", " + i12);
        }
        throw new IndexOutOfBoundsException("End index: " + i12 + " >= " + i13);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? EMPTY : balancedConcat(iterable.iterator(), size);
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i11) {
        checkRange(0, i11, byteBuffer.remaining());
        byte[] bArr = new byte[i11];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(byte[] bArr, int i11, int i12) {
        checkRange(i11, i11 + i12, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i11, i12));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(w.f8998b));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String str, int i11) {
        int hexDigit = hexDigit(str.charAt(i11));
        if (hexDigit != -1) {
            return hexDigit;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i11) + " at index " + i11);
    }

    public static ByteString fromHex(String str) {
        if (str.length() % 2 != 0) {
            throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) (extractHexDigit(str, i12 + 1) | (extractHexDigit(str, i12) << 4));
        }
        return new LiteralByteString(bArr);
    }

    private static int hexDigit(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'A' && c11 <= 'F') {
            return c11 - '7';
        }
        if (c11 < 'a' || c11 > 'f') {
            return -1;
        }
        return c11 - 'W';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f newCodedBuilder(int i11) {
        return new f(i11, null);
    }

    public static g newOutput() {
        return new g(128);
    }

    public static g newOutput(int i11) {
        return new g(i11);
    }

    static ByteString nioByteString(ByteBuffer byteBuffer) {
        return new NioByteString(byteBuffer);
    }

    private static ByteString readChunk(InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read == -1) {
                break;
            }
            i12 += read;
        }
        if (i12 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i12);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public static ByteString readFrom(InputStream inputStream, int i11) throws IOException {
        return readFrom(inputStream, i11, i11);
    }

    public static ByteString readFrom(InputStream inputStream, int i11, int i12) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i11);
            if (readChunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(readChunk);
            i11 = Math.min(i11 * 2, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInt(byte b11) {
        return b11 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return g1.a(this);
        }
        return g1.a(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr, int i11, int i12) {
        return new BoundedByteString(bArr, i11, i12);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i11);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i11) {
        copyTo(bArr, 0, i11, size());
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i11, int i12, int i13) {
        checkRange(i11, i11 + i13, size());
        checkRange(i12, i12 + i13, bArr.length);
        if (i13 > 0) {
            copyToInternal(bArr, i11, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i11, int i12, int i13);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTreeDepth();

    public final int hashCode() {
        int i11 = this.hash;
        if (i11 == 0) {
            int size = size();
            i11 = partialHash(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.hash = i11;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    public abstract i newCodedInput();

    public abstract InputStream newInput();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialHash(int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i11) {
        return substring(i11, size());
    }

    public abstract ByteString substring(int i11, int i12);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return w.f9000d;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay());
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e11) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e11);
            throw unsupportedEncodingException;
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    protected abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(w.f8998b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeTo(androidx.datastore.preferences.protobuf.h hVar) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    final void writeTo(OutputStream outputStream, int i11, int i12) throws IOException {
        checkRange(i11, i11 + i12, size());
        if (i12 > 0) {
            writeToInternal(outputStream, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToReverse(androidx.datastore.preferences.protobuf.h hVar) throws IOException;
}
