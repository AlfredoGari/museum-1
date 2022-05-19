package com.museum.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.museum.service.UserService;
import com.museum.domain.Item;
import com.museum.domain.Item_resumido;
import com.museum.domain.Role;
import com.museum.domain.User;
import com.museum.domain.image_gallery;
import com.museum.repo.ImageGalleryRepo;
import com.museum.repo.ItemRepo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemRepo itemrepo;
	
	@Autowired
	private ImageGalleryRepo imagerepo;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>>getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<User>saveUser(@RequestBody User user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role>saveRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
	
	@PostMapping("/role/addtouser")
	public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
		
		userService.addRoleToUser(form.getUserName(),form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/items")
	public List<Item_resumido> listar(){
		List<Item> listacompleta;
		List<Item_resumido> listaacotada = new ArrayList<Item_resumido>();
		listacompleta = itemrepo.findAll();
		Collection<image_gallery> ig;
		
		for(int i=0; i<listacompleta.size();i++) {
			Item_resumido ir = new Item_resumido();
			ir.setPublic_id(listacompleta.get(i).getId());
			ir.setRoom_name(listacompleta.get(i).getRoom_name());
			ir.setTitle(listacompleta.get(i).getTitle());
			ir.setIntroduction(listacompleta.get(i).getIntroduction());
			ig=listacompleta.get(i).getIg();
			
			for(image_gallery gfg : ig) {
				if(gfg.getIs_main()) {
					ir.setMain_image_url(gfg.getImage_url());
				}
			}
			
			listaacotada.add(ir);
		
		}
		return listaacotada;
	}
	
	@GetMapping("/item/{id}")
	public Optional<Item> buscarItem(@PathVariable("id") Long id){
		return itemrepo.findById(id);
	}
	
	@PostMapping("/guardaritem")
	public void guardaritem(@RequestBody Item item) {
		itemrepo.save(item);
	}
	
	@PostMapping("/guardarimagen")
	public void guardarimagen(@RequestBody image_gallery ig) {
		imagerepo.save(ig);
	}
	
	
	
	
}

@Data
class RoleToUserForm { 
	private String userName;
	private String roleName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
