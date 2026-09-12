package org.apache.tools.zip;

import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    static /* synthetic */ Class class$org$apache$tools$zip$AsiExtraField;
    static /* synthetic */ Class class$org$apache$tools$zip$JarMarker;
    private static Hashtable implementations = new Hashtable();

    static {
        Class cls = class$org$apache$tools$zip$AsiExtraField;
        if (cls == null) {
            cls = class$("org.apache.tools.zip.AsiExtraField");
            class$org$apache$tools$zip$AsiExtraField = cls;
        }
        register(cls);
        Class cls2 = class$org$apache$tools$zip$JarMarker;
        if (cls2 == null) {
            cls2 = class$("org.apache.tools.zip.JarMarker");
            class$org$apache$tools$zip$JarMarker = cls2;
        }
        register(cls2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = (Class) implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i11 = 0;
        for (int i12 = 0; i12 < zipExtraFieldArr.length; i12++) {
            System.arraycopy(zipExtraFieldArr[i12].getHeaderId().getBytes(), 0, bArr, i11, 2);
            System.arraycopy(zipExtraFieldArr[i12].getCentralDirectoryLength().getBytes(), 0, bArr, i11 + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i12].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData, 0, bArr, i11 + 4, centralDirectoryData.length);
            i11 += centralDirectoryData.length + 4;
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        int length = zipExtraFieldArr.length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            length += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[length];
        int i11 = 0;
        for (int i12 = 0; i12 < zipExtraFieldArr.length; i12++) {
            System.arraycopy(zipExtraFieldArr[i12].getHeaderId().getBytes(), 0, bArr, i11, 2);
            System.arraycopy(zipExtraFieldArr[i12].getLocalFileDataLength().getBytes(), 0, bArr, i11 + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i12].getLocalFileDataData();
            System.arraycopy(localFileDataData, 0, bArr, i11 + 4, localFileDataData.length);
            i11 += localFileDataData.length + 4;
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        Vector vector = new Vector();
        int i11 = 0;
        while (i11 <= bArr.length - 4) {
            ZipShort zipShort = new ZipShort(bArr, i11);
            int value = new ZipShort(bArr, i11 + 2).getValue();
            int i12 = i11 + 4;
            if (i12 + value > bArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("data starting at ");
                stringBuffer.append(i11);
                stringBuffer.append(" is in unknown format");
                throw new ZipException(stringBuffer.toString());
            }
            try {
                ZipExtraField createExtraField = createExtraField(zipShort);
                createExtraField.parseFromLocalFileData(bArr, i12, value);
                vector.addElement(createExtraField);
                i11 += value + 4;
            } catch (IllegalAccessException e11) {
                throw new ZipException(e11.getMessage());
            } catch (InstantiationException e12) {
                throw new ZipException(e12.getMessage());
            }
        }
        if (i11 == bArr.length) {
            ZipExtraField[] zipExtraFieldArr = new ZipExtraField[vector.size()];
            vector.copyInto(zipExtraFieldArr);
            return zipExtraFieldArr;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("data starting at ");
        stringBuffer2.append(i11);
        stringBuffer2.append(" is in unknown format");
        throw new ZipException(stringBuffer2.toString());
    }

    public static void register(Class cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cls);
            stringBuffer.append(" doesn't implement ZipExtraField");
            throw new RuntimeException(stringBuffer.toString());
        } catch (IllegalAccessException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(cls);
            stringBuffer2.append("'s no-arg constructor is not public");
            throw new RuntimeException(stringBuffer2.toString());
        } catch (InstantiationException unused3) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(cls);
            stringBuffer3.append(" is not a concrete class");
            throw new RuntimeException(stringBuffer3.toString());
        }
    }
}
