package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class n1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements c {
        final /* synthetic */ ByteString val$input;

        a(ByteString byteString) {
            this.val$input = byteString;
        }

        @Override // com.google.protobuf.n1.c
        public byte byteAt(int i11) {
            return this.val$input.byteAt(i11);
        }

        @Override // com.google.protobuf.n1.c
        public int size() {
            return this.val$input.size();
        }
    }

    /* loaded from: classes4.dex */
    class b implements c {
        final /* synthetic */ byte[] val$input;

        b(byte[] bArr) {
            this.val$input = bArr;
        }

        @Override // com.google.protobuf.n1.c
        public byte byteAt(int i11) {
            return this.val$input[i11];
        }

        @Override // com.google.protobuf.n1.c
        public int size() {
            return this.val$input.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface c {
        byte byteAt(int i11);

        int size();
    }

    private n1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String escapeBytes(ByteString byteString) {
        return escapeBytes(new a(byteString));
    }

    static String escapeBytes(c cVar) {
        StringBuilder sb2 = new StringBuilder(cVar.size());
        for (int i11 = 0; i11 < cVar.size(); i11++) {
            byte byteAt = cVar.byteAt(i11);
            if (byteAt == 34) {
                sb2.append("\\\"");
            } else if (byteAt == 39) {
                sb2.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (byteAt < 32 || byteAt > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb2.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb2.append((char) ((byteAt & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) byteAt);
                            break;
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    static String escapeBytes(byte[] bArr) {
        return escapeBytes(new b(bArr));
    }

    static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }
}
