package effective.java.item2.builder;

import java.util.Date;

public class Message {
	private long m_id;
	private String m_header;
	private String m_body;
	private String m_protocol;
	private String m_checksum;
	private String m_charset;
	private Date m_date;
	private String m_from;
	
	public static class Builder implements effective.java.item2.builder.Builder<Message> {

		private long m_id = -1;
		private String m_header = "";
		private String m_body = "";
		private String m_protocol = "";
		private String m_checksum = "";
		private String m_charset = "";
		private Date m_date = new Date();
		private String m_from = "";
		
		@Override
		public Message build() {
			return new Message(this);
		}
		
		public Builder(long inId) {
			m_id = inId;
		}
		
		public Builder header(String inHeader) {
			m_header = inHeader;
			return this;
		}
		public Builder body(String inBody) {
			m_body = inBody;
			return this;
		}
		public Builder protocol(String inProtocol) {
			m_protocol = inProtocol;
			return this;
		}
		public Builder checksum(String inChecksum) {
			m_checksum = inChecksum;
			return this;
		}
		public Builder charset(String inCharset) {
			m_charset = inCharset;
			return this;
		}
		public Builder date(Date inDate) {
			m_date = inDate;
			return this;
		}
		public Builder from(String inFrom) {
			m_from = inFrom;
			return this;
		}
	}
	
	private Message(Builder inBuilder) {
		m_id = inBuilder.m_id;
		m_header = inBuilder.m_header;
		m_body = inBuilder.m_body;
		m_protocol = inBuilder.m_protocol;
		m_checksum = inBuilder.m_checksum;
		m_charset = inBuilder.m_charset;
		m_date = inBuilder.m_date;
		m_from = inBuilder.m_from;
	}

	public long getId() {
		return m_id;
	}

	public String getHeader() {
		return m_header;
	}

	public String getBody() {
		return m_body;
	}

	public String getProtocol() {
		return m_protocol;
	}

	public String getChecksum() {
		return m_checksum;
	}

	public String getCharset() {
		return m_charset;
	}

	public Date getDate() {
		return m_date;
	}

	public String getFrom() {
		return m_from;
	}
}
