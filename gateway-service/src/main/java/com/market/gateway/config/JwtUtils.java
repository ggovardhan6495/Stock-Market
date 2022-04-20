package com.market.gateway.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.market.gateway.client.UserClient;
import com.market.gateway.dto.UserDto;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtUtils {

//	@Value("${market.app.jwtSecret}")
	  private String jwtSecret="JwtSuperSecretKey";
//	  @Value("${market.app.jwtExpirationMs}")
	  private int jwtExpirationMs = 864000000;

	private static final String SECRET_KEY = "JwtSuperSecretKey";
	private static final int TOKEN_VALIDITY = 3600 * 5;
/*
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
/*
  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = getAllClaimsFromToken(token);
      log.debug("Claims ===============>::{}", claims.getSubject());
      System.err.println("Claims ===============>:: "+ claims.getSubject());
      return claimsResolver.apply(claims);
  }
/*
  private Claims getAllClaimsFromToken(String token) {
	  Claims claims =   Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	  System.err.println("Claims ===============>:: "+ claims.getSubject());
	  return claims;
  }
/*
  public Boolean validateToken(String token, UserDetails userDetails) {
      final String username = getUsernameFromToken(token);
      return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
/*
  private Boolean isTokenExpired(String token) {
      final Date expiration = getExpirationDateFromToken(token);
      return expiration.before(new Date());
  }
/*
  public Date getExpirationDateFromToken(String token) {
      return getClaimFromToken(token, Claims::getExpiration);
  }
/*
  public String generateToken(UserDetails userDetails) {

      Map<String, Object> claims = new HashMap<>();

      return Jwts.builder()
              .setClaims(claims)
              .setSubject(userDetails.getUsername())
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
              .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
              .compact();
  }
*/
	@Autowired
	private UserClient userClient;

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = userClient.loadUserByUserName(username);
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					grantedAuthority(user));
		}else {
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
	}
	private Set grantedAuthority(UserDto user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		return authorities;
	}

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
