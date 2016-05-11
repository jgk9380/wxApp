package org.util.smsone.common;

/*
 *
 * <p>Title: MyJb</p>
 * <p>Description: test</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: runqian</p>
 * @author wenyt
 * @version 1.0
 */

public class Base64 {

	private static final byte[] encodeTable = new byte[] {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'+', '/' };

	private static final byte[] decodeTable = new byte[] {
			0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f,
			0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f,
			0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f, 0x3e, 0x7f, 0x7f, 0x7f, 0x3f,
			0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3a, 0x3b, 0x3c, 0x3d, 0x7f, 0x7f, 0x7f, 0x40, 0x7f, 0x7f,
			0x7f, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e,
			0x0f, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f,
			0x7f, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28,
			0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f, 0x30, 0x31, 0x32, 0x33, 0x7f, 0x7f, 0x7f, 0x7f, 0x7f };

	/**
	 * base64 
	 * @param srcBuf
	 * @param offset
	 * @param length
	 * @return
	 */
	public static final String encode(byte[] srcBuf, int offset, int length) {
		
		byte[] DecBuf = new byte[(length << 1) + 4];
		int i = offset, end = offset + length;
		int size= end - 2,counts = 0;
		short a, b, c;
		while (i < size) {
			a = srcBuf[i++];
			b = srcBuf[i++];
			c = srcBuf[i++];
			DecBuf[counts++] = encodeTable[(a >> 2) & 0x3f];
			DecBuf[counts++] = encodeTable[((b >> 4) & 0x0f) | ((a << 4) & 0x3f)];
			DecBuf[counts++] = encodeTable[((c >> 6) & 0x3) | ((b << 2) & 0x3f)];
			DecBuf[counts++] = encodeTable[c & 0x3f];
		}
		if (end - i == 2) {
			a = srcBuf[i++];
			b = srcBuf[i++];
			DecBuf[counts++] = encodeTable[(a >> 2) & 0x3f];
			DecBuf[counts++] = encodeTable[((b >> 4) & 0x0f)
					| ((a << 4) & 0x3f)];
			DecBuf[counts++] = encodeTable[(b << 2) & 0x3f];
			DecBuf[counts++] = '=';
		} else if (end - i == 1) {
			a = srcBuf[i++];
			DecBuf[counts++] = encodeTable[(a >> 2) & 0x3f];
			DecBuf[counts++] = encodeTable[(a << 4) & 0x3f];
			DecBuf[counts++] = '=';
			DecBuf[counts++] = '=';
		}
		return new String(DecBuf, 0, counts);
	}
	/**
	 * base64
	 * @param srcBuf
	 * @return
	 */
	public static final String encode(byte[] srcBuf) {
		return encode(srcBuf, 0, srcBuf.length);
	}
	/**
	 * base64
	 * @param srcString
	 * @return
	 * @throws RuntimeException
	 */
	public static final byte[] decode(String srcString) throws RuntimeException {
		byte index;
		short a = 0, b = 0, c = 0, d = 0;
		int i = 0, counts = 0;
		byte[] srcBuf = srcString.getBytes();
		int srcSize = srcBuf.length;
		int decSize = (srcSize >> 2);
		decSize += (decSize << 1);

		if (srcBuf[srcSize - 2] == '=') {
			decSize -= 2;
		} else if (srcBuf[srcSize - 1] == '=') {
			decSize -= 1;
		}
		byte[] decBuf = new byte[decSize];

		while (i < srcSize) {
			// a
			index = srcBuf[i++];
			if (index < 0) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			a = decodeTable[index];
			if (a >= 0x40) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			// b
			index = srcBuf[i++];
			if (index < 0) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			b = decodeTable[index];
			if (b >= 0x40) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			// c
			index = srcBuf[i++];
			if (index < 0) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			c = decodeTable[index];
			if (c >= 0x40) {
				if (c == 0x40) {
					decBuf[counts++] = (byte) ((a << 2) | ((b >> 4) & 0x03));
					return decBuf;
				}
				throw new RuntimeException("invalid base64 character:" + index);
			}
			// d
			index = srcBuf[i++];
			if (index < 0) {
				throw new RuntimeException("invalid base64 character:" + index);
			}
			d = decodeTable[index];
			if (d >= 0x40) {
				if (d == 0x40) {
					decBuf[counts++] = (byte) ((a << 2) | ((b >> 4) & 0x03));
					decBuf[counts++] = (byte) ((b << 4) | ((c >> 2) & 0x0f));
					return decBuf;
				}
				throw new RuntimeException("invalid base64 character:" + index);
			}

			decBuf[counts++] = (byte) ((a << 2) | ((b >> 4) & 0x03));
			decBuf[counts++] = (byte) ((b << 4) | ((c >> 2) & 0x0f));
			decBuf[counts++] = (byte) ((c << 6) | d);
		}
		return decBuf;
	}
}
