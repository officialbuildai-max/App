package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j implements h1 {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final i input;
    private int nextTag = 0;
    private int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private j(i iVar) {
        i iVar2 = (i) y.checkNotNull(iVar, "input");
        this.input = iVar2;
        iVar2.wrapper = this;
    }

    public static j forCodedInput(i iVar) {
        j jVar = iVar.wrapper;
        return jVar != null ? jVar : new j(iVar);
    }

    private <T> void mergeGroupFieldInternal(T t11, i1 i1Var, o oVar) throws IOException {
        int i11 = this.endGroupTag;
        this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        try {
            i1Var.mergeFrom(t11, this, oVar);
            if (this.tag == this.endGroupTag) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } finally {
            this.endGroupTag = i11;
        }
    }

    private <T> void mergeMessageFieldInternal(T t11, i1 i1Var, o oVar) throws IOException {
        int readUInt32 = this.input.readUInt32();
        i iVar = this.input;
        if (iVar.recursionDepth >= iVar.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = iVar.pushLimit(readUInt32);
        this.input.recursionDepth++;
        i1Var.mergeFrom(t11, this, oVar);
        this.input.checkLastTagWas(0);
        r5.recursionDepth--;
        this.input.popLimit(pushLimit);
    }

    private Object readField(WireFormat.FieldType fieldType, Class<?> cls, o oVar) throws IOException {
        switch (a.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return readMessage(cls, oVar);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T readGroup(i1 i1Var, o oVar) throws IOException {
        T t11 = (T) i1Var.newInstance();
        mergeGroupFieldInternal(t11, i1Var, oVar);
        i1Var.makeImmutable(t11);
        return t11;
    }

    private <T> T readMessage(i1 i1Var, o oVar) throws IOException {
        T t11 = (T) i1Var.newInstance();
        mergeMessageFieldInternal(t11, i1Var, oVar);
        i1Var.makeImmutable(t11);
        return t11;
    }

    private void requirePosition(int i11) throws IOException {
        if (this.input.getTotalBytesRead() != i11) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void requireWireType(int i11) throws IOException {
        if (WireFormat.getTagWireType(this.tag) != i11) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void verifyPackedFixed32Length(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void verifyPackedFixed64Length(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.google.protobuf.h1
    public int getFieldNumber() throws IOException {
        int i11 = this.nextTag;
        if (i11 != 0) {
            this.tag = i11;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        int i12 = this.tag;
        if (i12 == 0 || i12 == this.endGroupTag) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i12);
    }

    @Override // com.google.protobuf.h1
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.protobuf.h1
    public <T> void mergeGroupField(T t11, i1 i1Var, o oVar) throws IOException {
        requireWireType(3);
        mergeGroupFieldInternal(t11, i1Var, oVar);
    }

    @Override // com.google.protobuf.h1
    public <T> void mergeMessageField(T t11, i1 i1Var, o oVar) throws IOException {
        requireWireType(2);
        mergeMessageFieldInternal(t11, i1Var, oVar);
    }

    @Override // com.google.protobuf.h1
    public boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.protobuf.h1
    public void readBoolList(List<Boolean> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof f)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Boolean.valueOf(this.input.readBool()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.input.readBool()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        f fVar = (f) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                fVar.addBoolean(this.input.readBool());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            fVar.addBoolean(this.input.readBool());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public ByteString readBytes() throws IOException {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.protobuf.h1
    public void readBytesList(List<ByteString> list) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.protobuf.h1
    public double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.protobuf.h1
    public void readDoubleList(List<Double> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof l)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Double.valueOf(this.input.readDouble()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Double.valueOf(this.input.readDouble()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        l lVar = (l) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                lVar.addDouble(this.input.readDouble());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            lVar.addDouble(this.input.readDouble());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public int readEnum() throws IOException {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.protobuf.h1
    public void readEnumList(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readEnum()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readEnum()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                wVar.addInt(this.input.readEnum());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            wVar.addInt(this.input.readEnum());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public int readFixed32() throws IOException {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.protobuf.h1
    public void readFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                wVar.addInt(this.input.readFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            wVar.addInt(this.input.readFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public long readFixed64() throws IOException {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.protobuf.h1
    public void readFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof k0)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Long.valueOf(this.input.readFixed64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readFixed64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        k0 k0Var = (k0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                k0Var.addLong(this.input.readFixed64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            k0Var.addLong(this.input.readFixed64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.protobuf.h1
    public void readFloatList(List<Float> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof u)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Float.valueOf(this.input.readFloat()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.input.readFloat()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        u uVar = (u) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                uVar.addFloat(this.input.readFloat());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            uVar.addFloat(this.input.readFloat());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    @Deprecated
    public <T> T readGroup(Class<T> cls, o oVar) throws IOException {
        requireWireType(3);
        return (T) readGroup(d1.getInstance().schemaFor((Class) cls), oVar);
    }

    @Override // com.google.protobuf.h1
    @Deprecated
    public <T> T readGroupBySchemaWithCheck(i1 i1Var, o oVar) throws IOException {
        requireWireType(3);
        return (T) readGroup(i1Var, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.h1
    @Deprecated
    public <T> void readGroupList(List<T> list, i1 i1Var, o oVar) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.tag;
        do {
            list.add(readGroup(i1Var, oVar));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i11);
        this.nextTag = readTag;
    }

    @Override // com.google.protobuf.h1
    @Deprecated
    public <T> void readGroupList(List<T> list, Class<T> cls, o oVar) throws IOException {
        readGroupList(list, d1.getInstance().schemaFor((Class) cls), oVar);
    }

    @Override // com.google.protobuf.h1
    public int readInt32() throws IOException {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.protobuf.h1
    public void readInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                wVar.addInt(this.input.readInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            wVar.addInt(this.input.readInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public long readInt64() throws IOException {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.protobuf.h1
    public void readInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof k0)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        k0 k0Var = (k0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                k0Var.addLong(this.input.readInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            k0Var.addLong(this.input.readInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r7.input.popLimit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void readMap(java.util.Map<K, V> r8, com.google.protobuf.m0.b r9, com.google.protobuf.o r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.requireWireType(r0)
            com.google.protobuf.i r1 = r7.input
            int r1 = r1.readUInt32()
            com.google.protobuf.i r2 = r7.input
            int r1 = r2.pushLimit(r1)
            java.lang.Object r2 = r9.defaultKey
            java.lang.Object r3 = r9.defaultValue
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.i r5 = r7.input     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.isAtEnd()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.WireFormat$FieldType r4 = r9.valueType     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.defaultValue     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.readField(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            com.google.protobuf.WireFormat$FieldType r4 = r9.keyType     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.readField(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.i r8 = r7.input
            r8.popLimit(r1)
            return
        L67:
            com.google.protobuf.i r9 = r7.input
            r9.popLimit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.readMap(java.util.Map, com.google.protobuf.m0$b, com.google.protobuf.o):void");
    }

    @Override // com.google.protobuf.h1
    public <T> T readMessage(Class<T> cls, o oVar) throws IOException {
        requireWireType(2);
        return (T) readMessage(d1.getInstance().schemaFor((Class) cls), oVar);
    }

    @Override // com.google.protobuf.h1
    public <T> T readMessageBySchemaWithCheck(i1 i1Var, o oVar) throws IOException {
        requireWireType(2);
        return (T) readMessage(i1Var, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.h1
    public <T> void readMessageList(List<T> list, i1 i1Var, o oVar) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i11 = this.tag;
        do {
            list.add(readMessage(i1Var, oVar));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i11);
        this.nextTag = readTag;
    }

    @Override // com.google.protobuf.h1
    public <T> void readMessageList(List<T> list, Class<T> cls, o oVar) throws IOException {
        readMessageList(list, d1.getInstance().schemaFor((Class) cls), oVar);
    }

    @Override // com.google.protobuf.h1
    public int readSFixed32() throws IOException {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.protobuf.h1
    public void readSFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readSFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readSFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                wVar.addInt(this.input.readSFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            wVar.addInt(this.input.readSFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public long readSFixed64() throws IOException {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.protobuf.h1
    public void readSFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof k0)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Long.valueOf(this.input.readSFixed64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readSFixed64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        k0 k0Var = (k0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                k0Var.addLong(this.input.readSFixed64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            k0Var.addLong(this.input.readSFixed64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.protobuf.h1
    public void readSInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readSInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readSInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                wVar.addInt(this.input.readSInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            wVar.addInt(this.input.readSInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.protobuf.h1
    public void readSInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof k0)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readSInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readSInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        k0 k0Var = (k0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                k0Var.addLong(this.input.readSInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            k0Var.addLong(this.input.readSInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public String readString() throws IOException {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.protobuf.h1
    public void readStringList(List<String> list) throws IOException {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z10) throws IOException {
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof i0) || z10) {
            do {
                list.add(z10 ? readStringRequireUtf8() : readString());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        i0 i0Var = (i0) list;
        do {
            i0Var.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public void readStringListRequireUtf8(List<String> list) throws IOException {
        readStringListInternal(list, true);
    }

    @Override // com.google.protobuf.h1
    public String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // com.google.protobuf.h1
    public int readUInt32() throws IOException {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.protobuf.h1
    public void readUInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof w)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readUInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readUInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        w wVar = (w) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                wVar.addInt(this.input.readUInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            wVar.addInt(this.input.readUInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public long readUInt64() throws IOException {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.protobuf.h1
    public void readUInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (!(list instanceof k0)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readUInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readUInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        k0 k0Var = (k0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                k0Var.addLong(this.input.readUInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            k0Var.addLong(this.input.readUInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.protobuf.h1
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.protobuf.h1
    public boolean skipField() throws IOException {
        int i11;
        if (this.input.isAtEnd() || (i11 = this.tag) == this.endGroupTag) {
            return false;
        }
        return this.input.skipField(i11);
    }
}
