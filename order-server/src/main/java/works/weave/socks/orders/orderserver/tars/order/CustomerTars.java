// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package works.weave.socks.orders.orderserver.tars.order;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class CustomerTars {

	@TarsStructProperty(order = 0, isRequire = false)
	public String id = "";
	@TarsStructProperty(order = 1, isRequire = false)
	public String firstName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public String lastName = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public String username = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public java.util.List<AddressTars> addresses = null;
	@TarsStructProperty(order = 5, isRequire = false)
	public java.util.List<CardTars> cards = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public java.util.List<AddressTars> getAddresses() {
		return addresses;
	}

	public void setAddresses(java.util.List<AddressTars> addresses) {
		this.addresses = addresses;
	}

	public java.util.List<CardTars> getCards() {
		return cards;
	}

	public void setCards(java.util.List<CardTars> cards) {
		this.cards = cards;
	}

	public CustomerTars() {
	}

	public CustomerTars(String id, String firstName, String lastName, String username, java.util.List<AddressTars> addresses, java.util.List<CardTars> cards) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.addresses = addresses;
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(id);
		result = prime * result + TarsUtil.hashCode(firstName);
		result = prime * result + TarsUtil.hashCode(lastName);
		result = prime * result + TarsUtil.hashCode(username);
		result = prime * result + TarsUtil.hashCode(addresses);
		result = prime * result + TarsUtil.hashCode(cards);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CustomerTars)) {
			return false;
		}
		CustomerTars other = (CustomerTars) obj;
		return (
			TarsUtil.equals(id, other.id) &&
			TarsUtil.equals(firstName, other.firstName) &&
			TarsUtil.equals(lastName, other.lastName) &&
			TarsUtil.equals(username, other.username) &&
			TarsUtil.equals(addresses, other.addresses) &&
			TarsUtil.equals(cards, other.cards) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != id) {
			_os.write(id, 0);
		}
		if (null != firstName) {
			_os.write(firstName, 1);
		}
		if (null != lastName) {
			_os.write(lastName, 2);
		}
		if (null != username) {
			_os.write(username, 3);
		}
		if (null != addresses) {
			_os.write(addresses, 4);
		}
		if (null != cards) {
			_os.write(cards, 5);
		}
	}

	static java.util.List<AddressTars> cache_addresses;
	static { 
		cache_addresses = new java.util.ArrayList<AddressTars>();
		AddressTars var_2 = new AddressTars();
		cache_addresses.add(var_2);
	}
	static java.util.List<CardTars> cache_cards;
	static { 
		cache_cards = new java.util.ArrayList<CardTars>();
		CardTars var_3 = new CardTars();
		cache_cards.add(var_3);
	}

	public void readFrom(TarsInputStream _is) {
		this.id = _is.readString(0, false);
		this.firstName = _is.readString(1, false);
		this.lastName = _is.readString(2, false);
		this.username = _is.readString(3, false);
		this.addresses = (java.util.List<AddressTars>) _is.read(cache_addresses, 4, false);
		this.cards = (java.util.List<CardTars>) _is.read(cache_cards, 5, false);
	}

}