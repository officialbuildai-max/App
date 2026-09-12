package com.google.protobuf;

import com.google.protobuf.WireFormat;

/* loaded from: classes4.dex */
public abstract class m {
    public abstract Object getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract s0 getMessageDefaultInstance();

    public abstract int getNumber();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
