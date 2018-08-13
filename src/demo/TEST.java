package demo;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import demo.conf.SerialConf;
import demo.util.HexUtils;
import demo.util.SerialPortUtils;

public class TEST {
	static SerialPort serialPort = null;
	// System.out.println("found data");
	static byte[] data = null;

	public static void main(String[] args) {

		try {
			serialPort = SerialPortUtils.openPort(SerialConf.PORT_NAME);

			SerialPortUtils.sendToPort(serialPort,
					HexUtils.hexStringToBytes(SerialConf.REQUEST_COIN_ID));
			SerialPortUtils.addListener(serialPort,
					new SerialPortEventListener() {

						@Override
						public void serialEvent(SerialPortEvent serialPortEvent) {
							// TODO Auto-generated method stub

							switch (serialPortEvent.getEventType()) {

							case SerialPortEvent.BI: // 10 通讯中断

							case SerialPortEvent.OE: // 7 溢位（溢出）错误

							case SerialPortEvent.FE: // 9 帧错误

							case SerialPortEvent.PE: // 8 奇偶校验错误

							case SerialPortEvent.CD: // 6 载波检测

							case SerialPortEvent.CTS: // 3 清除待发送数据

							case SerialPortEvent.DSR: // 4 待发送数据准备好了

							case SerialPortEvent.RI: // 5 振铃指示

							case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2
																		// 输出缓冲区已清空
								break;

							case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据

								data = SerialPortUtils.readFromPort(serialPort); // 读取数据，存入字节数组
								// 020101b80143 01060200 43 4e 30 31 30 42 93

								System.out.println(HexUtils
										.bytesToHexString(data));

								break;

							}

						}
					});

			System.out.println(HexUtils.bytesToHexString(data));

			// serialPort.close();

		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 以内部类形式创建一个串口监听类
	 * 
	 * @author zhong
	 * 
	 */
	private static class SerialListener11 implements SerialPortEventListener {

		/**
		 * 处理监控到的串口事件
		 */
		public void serialEvent(SerialPortEvent serialPortEvent) {

			switch (serialPortEvent.getEventType()) {

			case SerialPortEvent.BI: // 10 通讯中断

			case SerialPortEvent.OE: // 7 溢位（溢出）错误

			case SerialPortEvent.FE: // 9 帧错误

			case SerialPortEvent.PE: // 8 奇偶校验错误

			case SerialPortEvent.CD: // 6 载波检测

			case SerialPortEvent.CTS: // 3 清除待发送数据

			case SerialPortEvent.DSR: // 4 待发送数据准备好了

			case SerialPortEvent.RI: // 5 振铃指示

			case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
				break;

			case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据

				// System.out.println("found data");
				byte[] data = null;

				data = SerialPortUtils.readFromPort(serialPort); // 读取数据，存入字节数组

				System.out.println(HexUtils.bytesToHexString(data));

				break;

			}

		}

	}

}
