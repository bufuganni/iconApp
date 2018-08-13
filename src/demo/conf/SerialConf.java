package demo.conf;

public class SerialConf {
	
	
	
	/**
	 * 串口名称
	 */
	public static final String PORT_NAME = "COM3";
	
	/**
	 * 询问 pelicano 是否在线
	 */
	public static final String POLL = "020001FEFF";
	
	
	/**
	 * 测试电磁铁，每个电磁线圈依次给 200ms 时间，如果有分别器会增加响应的时间，分币器上有两个电磁铁
	 */
	public static final String TEST_SOLENID = "020101F0010B";
	
	/**
	 * 更改识别硬币的速 0x64=3  枚/s 
	 */
	public static final String OPEATE_MOTORS3 = "020201EF0A649E";
	/**
	 * 更改识别硬币的速 0x85=4  枚/s 
	 */
	public static final String OPEATE_MOTORS4 = "020201EF0A8570";
		
	/**
	 * 打开清除异物/清空硬币闸门
	 */
	public static final String OPEATE_TRASHDOOR = "020101EF010C";
	
	/**
	 * 自检
	 */
	public static final String SELF_CHECK = "020001E815";
	
	/**
	 * 询问硬币 ID
	 */
	public static final String REQUEST_COIN_ID = "020101B80143";


}
