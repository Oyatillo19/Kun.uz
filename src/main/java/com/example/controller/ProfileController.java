package com.example.controller;

import com.example.dto.JwtDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.enums.ProfileRole;
import com.example.service.ProfileService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/private/create")
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto,
                                             @RequestHeader("Authorization") String authorization) {
        JwtDTO jwtDTO = JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
        return ResponseEntity.ok(profileService.create(dto, null));
    }

//    @PutMapping(value = "/private/update")
//    public ResponseEntity<?> update(@RequestHeader("Authorization") String authorization,
//                                    @RequestBody ProfileDTO dto) {
//        JwtDTO jwtDTO = JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
//        return ResponseEntity.ok(profileService.update(null, dto));
//    }

    @PutMapping(value = "/updateByProfile")
    public ResponseEntity<?> updateByProfile(@RequestHeader("Authorization") String authorization,
                                             @RequestBody ProfileDTO dto) {
        String[] str = authorization.split(" ");
        String jwt = str[1];
        JwtDTO jwtDTO = JwtUtil.decode(jwt);
        return ResponseEntity.ok(profileService.updateOwnProfile(null, dto));
    }

    @PutMapping(value = "/private/paging")
    public ResponseEntity<Page<ProfileDTO>> paging(@RequestHeader("Authorization") String authorization,
                                                   @RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "size", defaultValue = "2") int size) {
        JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
        Page<ProfileDTO> response = profileService.pagingtion(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getProfileList")
    public ResponseEntity<List<ProfileDTO>> getAll() {
        List<ProfileDTO> list = profileService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getById(@PathVariable("id") Integer id) {
        ProfileDTO dto = profileService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/private/delete/{id}")
    public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization,
                                    @PathVariable("id") Integer id) {
        JwtUtil.getJwtDTO(authorization, ProfileRole.ADMIN);
        return ResponseEntity.ok(profileService.delete(id));
    }


}
