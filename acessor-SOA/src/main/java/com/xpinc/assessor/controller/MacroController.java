package com.xpinc.assessor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpinc.assessor.domain.model.VariavelMacro;
import com.xpinc.assessor.service.MacroSnapshotService;

@RestController
@RequestMapping("/macros")
public class MacroController {
	private final MacroSnapshotService svc;

	public MacroController(MacroSnapshotService svc) {
		this.svc = svc;
	}

	@GetMapping("/snapshot")
	public VariavelMacro snapshotSelic() {
		return svc.snapshotSelic();
	}
}