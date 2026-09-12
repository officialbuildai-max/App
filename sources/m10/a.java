package m10;

import android.support.v4.media.session.c;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import org.mvel2.b;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.util.InternalNumber;
import org.mvel2.util.m;
import org.mvel2.util.r;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final MathContext f69222a = MathContext.DECIMAL128;

    private static Object a(int i11, Object obj, int i12, int i13, Object obj2) {
        if (i12 < 20) {
            if (((i11 > 49 || i12 == 18 || i12 == 19) && i11 == i13) || (l(i11) && l(i13) && i12 >= 6 && i12 <= 13)) {
                return h(i11, obj, i12, obj2);
            }
            if (m(i11, obj, i12, i13, obj2)) {
                return i(k(obj, i11), i12, k(obj2, i13), true, b(i13) > b(i11) ? b(i13) : b(i11));
            }
            if (i12 != 0 && ((i11 == 15 || i13 == 15) && i11 != i13 && i11 != 200 && i13 != 200)) {
                return d(i11, b.b(obj, Boolean.class), i12, b.b(obj2, Boolean.class));
            }
            if ((i11 == 1 || i13 == 1) && (i11 == 8 || i11 == 112 || i13 == 8 || i13 == 112)) {
                return i11 == 1 ? d(i11, obj, i12, String.valueOf(obj2)) : d(i11, String.valueOf(obj), i12, obj2);
            }
        }
        return d(i11, obj, i12, obj2);
    }

    private static int b(int i11) {
        if (i11 == 7) {
            return 15;
        }
        if (i11 == 8) {
            return 112;
        }
        if (i11 == 9) {
            return 113;
        }
        switch (i11) {
            case 100:
                return 105;
            case 101:
                return 106;
            case 102:
                return 107;
            case 103:
                return 109;
            case 104:
                return TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY;
            default:
                return i11;
        }
    }

    private static Object c(BigDecimal bigDecimal, int i11, BigDecimal bigDecimal2, boolean z10, int i12) {
        if (i11 == 0) {
            return z10 ? m.r0(bigDecimal.add(bigDecimal2, f69222a), i12) : bigDecimal.add(bigDecimal2, f69222a);
        }
        if (i11 == 1) {
            return z10 ? m.r0(bigDecimal.subtract(bigDecimal2, f69222a), i12) : bigDecimal.subtract(bigDecimal2, f69222a);
        }
        if (i11 == 2) {
            return z10 ? m.r0(bigDecimal.multiply(bigDecimal2, f69222a), i12) : bigDecimal.multiply(bigDecimal2, f69222a);
        }
        if (i11 == 3) {
            return z10 ? m.r0(bigDecimal.divide(bigDecimal2, f69222a), i12) : bigDecimal.divide(bigDecimal2, f69222a);
        }
        if (i11 == 4) {
            return z10 ? m.r0(bigDecimal.remainder(bigDecimal2), i12) : bigDecimal.remainder(bigDecimal2);
        }
        if (i11 == 5) {
            return z10 ? m.r0(bigDecimal.pow(bigDecimal2.intValue(), f69222a), i12) : bigDecimal.pow(bigDecimal2.intValue(), f69222a);
        }
        switch (i11) {
            case 14:
                return bigDecimal.compareTo(bigDecimal2) == -1 ? Boolean.TRUE : Boolean.FALSE;
            case 15:
                return bigDecimal.compareTo(bigDecimal2) == 1 ? Boolean.TRUE : Boolean.FALSE;
            case 16:
                return bigDecimal.compareTo(bigDecimal2) <= 0 ? Boolean.TRUE : Boolean.FALSE;
            case 17:
                return bigDecimal.compareTo(bigDecimal2) >= 0 ? Boolean.TRUE : Boolean.FALSE;
            case 18:
                return bigDecimal.compareTo(bigDecimal2) == 0 ? Boolean.TRUE : Boolean.FALSE;
            case 19:
                return bigDecimal.compareTo(bigDecimal2) != 0 ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }

    private static Object d(int i11, Object obj, int i12, Object obj2) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        if (i12 == 0) {
            if (i11 == 50) {
                ArrayList arrayList = new ArrayList((Collection) obj);
                arrayList.add(obj2);
                return arrayList;
            }
            return String.valueOf(obj) + String.valueOf(obj2);
        }
        boolean z10 = true;
        if (i12 != 1 && i12 != 2 && i12 != 3 && i12 != 4) {
            if (i12 == 27) {
                return Boolean.valueOf(r.a(String.valueOf(obj)).equals(r.a(String.valueOf(obj2))));
            }
            switch (i12) {
                case 14:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) <= -1) {
                                bool = Boolean.TRUE;
                                return bool;
                            }
                        } catch (ClassCastException e11) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e11);
                        }
                    }
                    bool = Boolean.FALSE;
                    return bool;
                case 15:
                    break;
                case 16:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) <= 0) {
                                bool2 = Boolean.TRUE;
                                return bool2;
                            }
                        } catch (ClassCastException e12) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e12);
                        }
                    }
                    bool2 = Boolean.FALSE;
                    return bool2;
                case 17:
                    if (!(obj instanceof Comparable)) {
                        return Boolean.FALSE;
                    }
                    if (obj2 != null) {
                        try {
                            if (((Comparable) obj).compareTo(obj2) >= 0) {
                                bool3 = Boolean.TRUE;
                                return bool3;
                            }
                        } catch (ClassCastException e13) {
                            throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e13);
                        }
                    }
                    bool3 = Boolean.FALSE;
                    return bool3;
                case 18:
                    return n(obj2, obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
                case 19:
                    return o(obj2, obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
                case 20:
                    return String.valueOf(obj) + String.valueOf(obj2);
                default:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("could not perform numeric operation on non-numeric types: left-type=");
                    sb2.append(obj != null ? obj.getClass().getName() : "null");
                    sb2.append("; right-type=");
                    sb2.append(obj2 != null ? obj2.getClass().getName() : "null");
                    sb2.append(" [vals (");
                    sb2.append(String.valueOf(obj));
                    sb2.append(", ");
                    sb2.append(String.valueOf(obj2));
                    sb2.append(") operation=");
                    sb2.append(j10.a.a(i12));
                    sb2.append(" (opcode:");
                    sb2.append(i12);
                    sb2.append(") ]");
                    throw new RuntimeException(sb2.toString());
            }
        }
        if (!(obj instanceof Comparable)) {
            return Boolean.FALSE;
        }
        if (obj2 != null) {
            try {
                if ((((Comparable) obj).compareTo(obj2) >= 1 ? Boolean.TRUE : Boolean.FALSE).booleanValue()) {
                    return Boolean.valueOf(z10);
                }
            } catch (ClassCastException e14) {
                throw new RuntimeException("uncomparable values <<" + obj + ">> and <<" + obj2 + ">>", e14);
            }
        }
        z10 = false;
        return Boolean.valueOf(z10);
    }

    public static Object e(int i11, Object obj, int i12, int i13, Object obj2) {
        if (i11 == -1) {
            i11 = obj == null ? 0 : m.a(obj.getClass());
        }
        if (i13 == -1) {
            i13 = obj2 == null ? 0 : m.a(obj2.getClass());
        }
        return i11 != 110 ? a(i11, obj, i12, i13, obj2) : i13 != 110 ? i13 > 99 ? c((BigDecimal) obj, i12, j(obj2, i13), false, -1) : a(i11, obj, i12, i13, obj2) : c((BigDecimal) obj, i12, (BigDecimal) obj2, false, -1);
    }

    public static Object f(Object obj, int i11, int i12, Object obj2) {
        return e(obj == null ? 0 : m.a(obj.getClass()), obj, i11, i12, obj2);
    }

    public static Object g(Object obj, int i11, Object obj2) {
        return e(obj == null ? 0 : m.a(obj.getClass()), obj, i11, obj2 == null ? -1 : m.a(obj2.getClass()), obj2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x079d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object h(int r6, java.lang.Object r7, int r8, java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 2470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m10.a.h(int, java.lang.Object, int, java.lang.Object):java.lang.Object");
    }

    private static Object i(Number number, int i11, Number number2, boolean z10, int i12) {
        if (i11 == 0) {
            return p(Double.valueOf(number.doubleValue() + number2.doubleValue()), i12);
        }
        if (i11 == 1) {
            return p(Double.valueOf(number.doubleValue() - number2.doubleValue()), i12);
        }
        if (i11 == 2) {
            return p(Double.valueOf(number.doubleValue() * number2.doubleValue()), i12);
        }
        if (i11 == 3) {
            return p(Double.valueOf(number.doubleValue() / number2.doubleValue()), i12);
        }
        if (i11 == 4) {
            return p(Double.valueOf(number.doubleValue() % number2.doubleValue()), i12);
        }
        if (i11 == 5) {
            return p(Double.valueOf(Math.pow(number.doubleValue(), number2.doubleValue())), i12);
        }
        switch (i11) {
            case 14:
                return number.doubleValue() < number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 15:
                return number.doubleValue() > number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 16:
                return number.doubleValue() <= number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 17:
                return number.doubleValue() >= number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 18:
                return number.doubleValue() == number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            case 19:
                return number.doubleValue() != number2.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }

    private static InternalNumber j(Object obj, int i11) {
        if (obj == null || obj == BlankLiteral.INSTANCE) {
            return new InternalNumber(0, f69222a);
        }
        if (i11 == 1) {
            return new InternalNumber((String) obj, MathContext.DECIMAL64);
        }
        if (i11 != 15) {
            if (i11 == 300) {
                c.a(obj);
                throw null;
            }
            if (i11 != 7) {
                if (i11 != 8) {
                    if (i11 != 9) {
                        switch (i11) {
                            case 100:
                            case 105:
                                return new InternalNumber((int) ((Short) obj).shortValue(), MathContext.DECIMAL32);
                            case 101:
                            case 106:
                                return new InternalNumber(((Integer) obj).intValue(), MathContext.DECIMAL32);
                            case 102:
                            case 107:
                                return new InternalNumber(((Long) obj).longValue(), MathContext.DECIMAL64);
                            case 103:
                            case 109:
                                return new InternalNumber(((Double) obj).doubleValue(), MathContext.DECIMAL64);
                            case 104:
                            case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                                return new InternalNumber(((Float) obj).floatValue(), MathContext.DECIMAL64);
                            case 110:
                                return new InternalNumber(((BigDecimal) obj).doubleValue());
                            case 111:
                                return new InternalNumber((BigInteger) obj, MathContext.DECIMAL128);
                            case 112:
                                break;
                            case 113:
                                break;
                            default:
                                throw new RuntimeException("cannot convert <" + obj + "> to a numeric type: " + obj.getClass() + " [" + i11 + "]");
                        }
                    }
                    return new InternalNumber(((Byte) obj).intValue());
                }
                return new InternalNumber((int) ((Character) obj).charValue(), MathContext.DECIMAL32);
            }
        }
        return new InternalNumber(((Boolean) obj).booleanValue() ? 1 : 0);
    }

    private static Double k(Object obj, int i11) {
        if (obj == null || obj == BlankLiteral.INSTANCE) {
            return Double.valueOf(0.0d);
        }
        if (i11 == 1) {
            return Double.valueOf(Double.parseDouble((String) obj));
        }
        if (i11 == 15 || i11 == 7) {
            return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
        }
        if (i11 != 8) {
            if (i11 != 9) {
                switch (i11) {
                    case 100:
                    case 105:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 101:
                    case 106:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 102:
                    case 107:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 103:
                    case 109:
                        return (Double) obj;
                    case 104:
                    case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 110:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 111:
                        return Double.valueOf(((Number) obj).doubleValue());
                    case 112:
                        break;
                    case 113:
                        break;
                    default:
                        throw new RuntimeException("cannot convert <" + obj + "> to a numeric type: " + obj.getClass() + " [" + i11 + "]");
                }
            }
            return Double.valueOf(((Byte) obj).doubleValue());
        }
        return Double.valueOf(Double.parseDouble(String.valueOf((Character) obj)));
    }

    private static boolean l(int i11) {
        return i11 == 101 || i11 == 106 || i11 == 102 || i11 == 107;
    }

    private static boolean m(int i11, Object obj, int i12, int i13, Object obj2) {
        return (i11 > 99 && i13 > 99) || (i12 != 0 && ((i11 > 99 || i13 > 99 || i12 < 14 || i12 > 17) && m.g0(obj) && m.g0(obj2)));
    }

    private static Boolean n(Object obj, Object obj2) {
        boolean z10;
        if (obj != null) {
            return obj.equals(obj2) ? Boolean.TRUE : Boolean.FALSE;
        }
        if (obj2 != null) {
            if (!(obj2.equals(obj) ? Boolean.TRUE : Boolean.FALSE).booleanValue()) {
                z10 = false;
                return Boolean.valueOf(z10);
            }
        }
        z10 = true;
        return Boolean.valueOf(z10);
    }

    private static Boolean o(Object obj, Object obj2) {
        return obj != null ? !obj.equals(obj2) ? Boolean.TRUE : Boolean.FALSE : (obj2 == null || obj2.equals(obj)) ? Boolean.FALSE : Boolean.TRUE;
    }

    private static Object p(Number number, int i11) {
        if (i11 == 1) {
            return Double.valueOf(number.doubleValue());
        }
        switch (i11) {
            case 100:
            case 105:
                return Short.valueOf(number.shortValue());
            case 101:
            case 106:
                return Integer.valueOf(number.intValue());
            case 102:
            case 107:
                return Long.valueOf(number.longValue());
            case 103:
            case 109:
                return Double.valueOf(number.doubleValue());
            case 104:
            case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                return Float.valueOf(number.floatValue());
            case 110:
                return new BigDecimal(number.doubleValue());
            case 111:
                return BigInteger.valueOf(number.longValue());
            default:
                throw new RuntimeException("internal error: " + i11);
        }
    }
}
